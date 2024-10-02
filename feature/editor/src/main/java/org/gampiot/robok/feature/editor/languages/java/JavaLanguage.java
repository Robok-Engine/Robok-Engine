/*
 *    sora-editor - the awesome code editor for Android
 *    https://github.com/Rosemoe/sora-editor
 *    Copyright (C) 2020-2024  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */
package org.gampiot.robok.feature.editor.languages.java;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import static java.lang.Character.isWhitespace;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.github.rosemoe.sora.lang.EmptyLanguage;
import io.github.rosemoe.sora.lang.Language;
import io.github.rosemoe.sora.lang.QuickQuoteHandler;
import io.github.rosemoe.sora.lang.analysis.AnalyzeManager;
import io.github.rosemoe.sora.lang.completion.CompletionHelper;
import io.github.rosemoe.sora.lang.completion.CompletionPublisher;
import io.github.rosemoe.sora.lang.completion.SimpleSnippetCompletionItem;
import io.github.rosemoe.sora.lang.completion.SnippetDescription;
import io.github.rosemoe.sora.lang.completion.snippet.CodeSnippet;
import io.github.rosemoe.sora.lang.completion.snippet.parser.CodeSnippetParser;
import io.github.rosemoe.sora.lang.format.Formatter;
import io.github.rosemoe.sora.lang.smartEnter.NewlineHandleResult;
import io.github.rosemoe.sora.lang.smartEnter.NewlineHandler;
import io.github.rosemoe.sora.lang.styling.Styles;
import io.github.rosemoe.sora.lang.styling.StylesUtils;
import io.github.rosemoe.sora.text.CharPosition;
import io.github.rosemoe.sora.text.Content;
import io.github.rosemoe.sora.text.ContentReference;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.util.MyCharacter;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import io.github.rosemoe.sora.lang.completion.SimpleCompletionItem;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.lang.completion.CompletionItem;
import io.github.rosemoe.sora.lang.completion.CompletionItemKind;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticsContainer;
import io.github.rosemoe.sora.widget.CodeEditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.gampiot.robok.feature.editor.RobokCodeEditor;
import org.gampiot.robok.feature.editor.EditorListener;
import org.gampiot.robok.feature.editor.languages.java.object.ModifierAccess;
import org.gampiot.robok.feature.editor.languages.java.autocomplete.IdentifierAutoComplete;
import org.gampiot.robok.feature.editor.languages.java.models.*;
import org.gampiot.robok.feature.editor.languages.java.store.JavaClasses;

import org.robok.antlr.logic.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Java language.
 * Simple implementation.
 *
 * @author Rosemoe
 */
public class JavaLanguage implements Language, EditorListener, AntlrListener {

     private final static String TAG = "JavaLanguage";
     private final static CodeSnippet FOR_SNIPPET = CodeSnippetParser.parse("for(int ${1:i} = 0;$1 < ${2:count};$1++) {\n    $0\n}");
     private final static CodeSnippet STATIC_CONST_SNIPPET = CodeSnippetParser.parse("private final static ${1:type} ${2/(.*)/${1:/upcase}/} = ${3:value};");
     private final static CodeSnippet CLIPBOARD_SNIPPET = CodeSnippetParser.parse("${1:${CLIPBOARD}}");
     private final static JavaQuoteHandler JAVA_QUOTE_HANDLER = new JavaQuoteHandler();
     
     private IdentifierAutoComplete identifierAutoComplete;
     private JavaIncrementalAnalyzeManager javaAnalyzeManager;
     private Diagnostics diagnostics;
     private EditorListener editorListener;
     private static String log = "";
     private static HashMap<String, Variable> variablesMap;
     private static HashMap<String, Method> methodsMap;
     
     // Code Editor 
     private CodeEditor editor;
     
     // Cursor
     private int cursorIndex;
    
     // Method string editing
     private static String currentMethod = null;
    
     private static String inputText = "";
    
     public JavaLanguage(RobokCodeEditor editor, DiagnosticsContainer diagnosticsContainer) {
          init(editor, diagnosticsContainer);
     }
     
     private void init(RobokCodeEditor editor, DiagnosticsContainer diagnosticsContainer) {
          identifierAutoComplete = new IdentifierAutoComplete(editor.getContext(), JavaTextTokenizer.sKeywords);
          javaAnalyzeManager = new JavaIncrementalAnalyzeManager();
          variablesMap = new HashMap<>();
          methodsMap = new HashMap<>();
          this.editor = editor.getSoraCodeEditor();
          subscribeEventEditor();
          diagnostics = new JavaLanguage.Diagnostics();
          
          editorListener = this;
          diagnostics.diagnosticListener = this;
          diagnostics.diagnostics = diagnosticsContainer;
          start();
     }
     
     public static HashMap<String, Method> getMethods() {
          return methodsMap;
     }
     
     public static HashMap<String, Variable> getVariables() {
          return variablesMap;
     }
     
     public static String getInputText() {
          return inputText;
     }
     
     public void setEditorListener(EditorListener value) { 
          editorListener = value;
     }
     
     public void setAntlrListener(AntlrListener value) {
          diagnostics.diagnosticListener = value;
     }
     
     /*
     * This method is used to notify the editor that a new error dialigost has been received.
     * @param line an integer corresponding to the error line
     * @param positionStart corresponds to the first character of the error code.
     * @param positionEnd corresponds to the end character of the error code.
     * @param msg a message about the error to the user.
     */
     @Override
     public void onDiagnosticReceive(int line, int positionStart, int positionEnd, String msg) {
          onDiagnosticStatusReceive(true);
     }
     
     /*
     * This method is called when some diagnostic status is received. 
     * @param isError: returns whether it is an error or not.
     */
     @Override
     public void onDiagnosticStatusReceive(boolean isError) { }
     
     /*
     * This method is called whenever the editor text is changed.
     */
     @Override 
     public void onEditorTextChange () { }
    
     private void subscribeEventEditor(){
          editor.subscribeEvent(ContentChangeEvent.class, (event, undubscribe) -> {
                this.inputText = editor.getText().toString();
                editorListener.onEditorTextChange();
          });
     }
    
     private Runnable runnable;
     Handler handler = new Handler(Looper.getMainLooper());
     private void start() {
           runnable = new Runnable() {
                @Override
                public void run() {
                     if (diagnostics.onSuccess) {
                          diagnostics.CheckforPossibleErrors(inputText, cursorIndex);
                     }
                     handler.postDelayed(this, 1000);
                }
           };
           handler.postDelayed(runnable, 15);
     }

     @NonNull
     @Override
     public AnalyzeManager getAnalyzeManager() {
          return javaAnalyzeManager;
     }

     @Nullable
     @Override
     public QuickQuoteHandler getQuickQuoteHandler() {
          return JAVA_QUOTE_HANDLER;
     }

     @Override
     public void destroy() {
          identifierAutoComplete = null;
     }
 
     @Override
     public int getInterruptionLevel() {
          return INTERRUPTION_LEVEL_STRONG;
     }

     @Override
     public void requireAutoComplete(
         @NonNull ContentReference content, 
         @NonNull CharPosition position,
         @NonNull CompletionPublisher publisher, 
         @NonNull Bundle extraArguments
     ) {
         /*
           prefix: contains the text of the current line in parts, String type
           content: contains the text of all lines, appears to be a StringBuilder
           position: contains the positions of the character, line, column, index, type CharPosition
         */

         var prefix = CompletionHelper.computePrefix(
               content, 
               position, 
               MyCharacter::isJavaIdentifierPart
         );
         final var idt = javaAnalyzeManager.identifiers;

         int lineIndex = position.getLine(); // get the index of the current line from the position
         String currentLine = content.getLine(lineIndex).toString(); // get the line content

         // Now you have two variablesMap:
         // 'prefix' contains the word ending at the cursor
         // 'currentLine' contains the entire contents of the line where the cursor is located
         cursorIndex = position.getIndex(); // full text cursor index
        
         inputText = content.toString(); //Gets the text from the editor
                        
         if (idt != null) {
              identifierAutoComplete.setVariables(variablesMap);
              identifierAutoComplete.setMethods(methodsMap);
              identifierAutoComplete.requireAutoComplete(content, currentLine, position,prefix, publisher, idt, currentMethod);         
         }
        
         if ("fori".startsWith(prefix) && prefix.length() > 0) {
             publisher.addItem(new SimpleSnippetCompletionItem("fori", "Snippet - For loop on index", new SnippetDescription(prefix.length(), FOR_SNIPPET, true)));
         }
         if ("sconst".startsWith(prefix) && prefix.length() > 0) {
             publisher.addItem(new SimpleSnippetCompletionItem("sconst", "Snippet - Static Constant", new SnippetDescription(prefix.length(), STATIC_CONST_SNIPPET, true)));
         }
         if ("clip".startsWith(prefix) && prefix.length() > 0) {
             publisher.addItem(new SimpleSnippetCompletionItem("clip", "Snippet - Clipboard contents", new SnippetDescription(prefix.length(), CLIPBOARD_SNIPPET, true)));
         }
     }

     @Override
     public int getIndentAdvance(@NonNull ContentReference text, int line, int column) {
          var content = text.getLine(line).substring(0, column);
          return getIndentAdvance(content);
     }

     private int getIndentAdvance(String content) {
          JavaTextTokenizer t = new JavaTextTokenizer(content);
          Tokens token;
          int advance = 0;
          while ((token = t.nextToken()) != Tokens.EOF) {
                if (token == Tokens.LBRACE) {
                    advance++;
                }
          }
          advance = Math.max(0, advance);
          return advance * 4;
     }

     private final NewlineHandler[] newlineHandlers = new NewlineHandler[]{new BraceHandler()};

     @Override
     public boolean useTab() {
          return false;
     }

     @NonNull
     @Override
     public Formatter getFormatter() {
          return EmptyLanguage.EmptyFormatter.INSTANCE;
     }

     @Override
     public SymbolPairMatch getSymbolPairs() {
          return new SymbolPairMatch.DefaultSymbolPairs();
     }

     @Override
     public NewlineHandler[] getNewlineHandlers() {
          return newlineHandlers;
     }

     private static String getNonEmptyTextBefore(CharSequence text, int index, int length) {
          while (index > 0 && isWhitespace(text.charAt(index - 1))) {
              index--;
          }
          return text.subSequence(Math.max(0, index - length), index).toString();
     }

     private static String getNonEmptyTextAfter(CharSequence text, int index, int length) {
          while (index < text.length() && isWhitespace(text.charAt(index))) {
              index++;
          }
          return text.subSequence(index, Math.min(index + length, text.length())).toString();
     }

     private class BraceHandler implements NewlineHandler {

          @Override
          public boolean matchesRequirement(@NonNull Content text, @NonNull CharPosition position, @Nullable Styles style) {
               var line = text.getLine(position.line);
               return !StylesUtils.checkNoCompletion(style, position) && getNonEmptyTextBefore(line, position.column, 1).equals("{") &&
                       getNonEmptyTextAfter(line, position.column, 1).equals("}");
          }

          @NonNull
          @Override
          public NewlineHandleResult handleNewline(@NonNull Content text, @NonNull CharPosition position, @Nullable Styles style, int tabSize) {
               var line = text.getLine(position.line);
               int index = position.column;
               var beforeText = line.subSequence(0, index).toString();
               var afterText = line.subSequence(index, line.length()).toString();
               return handleNewline(beforeText, afterText, tabSize);
          }

          @NonNull
          public NewlineHandleResult handleNewline(String beforeText, String afterText, int tabSize) {
               int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
               int advanceBefore = getIndentAdvance(beforeText);
               int advanceAfter = getIndentAdvance(afterText);
               String text;
               StringBuilder sb = new StringBuilder("\n")
                      .append(TextUtils.createIndent(count + advanceBefore, tabSize, useTab()))
                      .append('\n')
                      .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
               int shiftLeft = text.length() + 1;
               return new NewlineHandleResult(sb, shiftLeft);
          }
     }

    
     private boolean codeIsVariable(String line) {
          Pattern pattern = Pattern.compile("((?:\\b(?:public|protected|private|static|final|native|volatile|synchronized|transient)\\b\\s*)+)?(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*=\\s*(.*?);");
          Matcher matcher = pattern.matcher(line);
          return matcher.matches();
     }

    private void extractDataVariable(String line) {
          Pattern pattern = Pattern.compile("((?:\\b(?:public|protected|private|static|final|native|volatile|synchronized|transient)\\b\\s*)+)?(\\b\\w+\\b)\\s+(\\b\\w+\\b)\\s*=\\s*(.*?);");
          Matcher matcher = pattern.matcher(line);

          if (matcher.find()) {
               String modify_access = matcher.group(1) != null ? matcher.group(1).trim() : "default";

               // thdev: here if macth is equal to var, it calls the ObjectVariable method, passing the match, otherwise it just receives
              String type = matcher.group(2);
              String name = matcher.group(3);
              String value = matcher.group(4);
          }
    }
    
    public class JavaListener extends Java8BaseListener {
        
         private int cursorIndex = 0;
        
         public JavaListener(int positionIndex){
              this.cursorIndex = positionIndex;
              JavaLanguage.currentMethod = null;
              variablesMap.clear();
              methodsMap.clear();
         }
        
         @Override
         public void enterMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
              if (ctx.start.getStartIndex() <= cursorIndex && ctx.stop.getStopIndex() >= cursorIndex) {
                   JavaLanguage.currentMethod = ctx.methodHeader().methodDeclarator().Identifier().getText();
              }
              // Capturing the access modifier
              List<Java8Parser.MethodModifierContext> accessModifiers = null;// Presume 'default' se nenhum modificador estiver presente
              if (ctx.methodModifier() != null && !ctx.methodModifier().isEmpty()) {
                    accessModifiers = ctx.methodModifier();
              }
              String returnType = ctx.methodHeader().result().getText();  // Capturing the method return type
              String methodName = ctx.methodHeader().methodDeclarator().Identifier().getText(); // Capturing the method name
              
              // Capturando os parâmetros do método
              List<String> parameters = new ArrayList<>();
              if (ctx.methodHeader().methodDeclarator().formalParameterList() != null) {
                    Java8Parser.FormalParameterListContext paramListCtx = ctx.methodHeader().methodDeclarator().formalParameterList();
                    if (paramListCtx.formalParameters() != null) {
                          for (Java8Parser.FormalParameterContext paramCtx : paramListCtx.formalParameters().formalParameter()) {
                                String paramType = paramCtx.unannType().getText();
                                String paramName = paramCtx.variableDeclaratorId().getText();
                                parameters.add(paramType + " " + paramName);
                          }
                    }
                    // Capturing the last parameter (can be VarArgs or a normal parameter)
                    if (paramListCtx.lastFormalParameter() != null) {
                          if (paramListCtx.lastFormalParameter().formalParameter() != null) {
                               // Parâmetro normal final
                               Java8Parser.FormalParameterContext lastParamCtx = paramListCtx.lastFormalParameter().formalParameter();
                               String paramType = lastParamCtx.unannType().getText();
                               String paramName = lastParamCtx.variableDeclaratorId().getText();
                               parameters.add(paramType + " " + paramName);
                          } else if (paramListCtx.lastFormalParameter().formalParameter().variableDeclaratorId() != null) {
                                // VarArgs parameter
                               Java8Parser.LastFormalParameterContext varArgsCtx = paramListCtx.lastFormalParameter();
                               String paramType = varArgsCtx.unannType().getText() + "...";
                               String paramName = varArgsCtx.variableDeclaratorId().getText();
                               parameters.add(paramType + " " + paramName);
                          }
                    }
              }
              Method method = new Method(accessModifiers, returnType, methodName, parameters);
              methodsMap.put(methodName, method);
         }  
         @Override
         public void enterLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext ctx) {
              String type = ctx.unannType().getText();
              String importPackage = "com.test.Test";
              importPackage = JavaClasses.getClasses().get(type);
              
              if(importPackage != null){
                  //this variable uses the JavaClass type
              }else{
                  //this variable uses other... (RDKClasses)
              }
            
              ModifierAccess accessModifier = null;
              String initialValue = null;
              String enclosingMethod = null; // Adds the variable to store the enclosing method or block
              if (ctx.variableModifier() != null && !ctx.variableModifier().isEmpty()) {
                    String modify = ctx.variableModifier(0).getText();
                    accessModifier = mapToModifierAccess(modify);
              }
              // Capturing the variable name and initial value
              for (Java8Parser.VariableDeclaratorContext varCtx : ctx.variableDeclaratorList().variableDeclarator()) {
                    String variableName = varCtx.variableDeclaratorId().getText();
                    if (varCtx.variableInitializer() != null) {
                         initialValue = varCtx.variableInitializer().getText();
                    }
                    // Determining the method or code block where the variable is declared
                    ParserRuleContext parentCtx = ctx.getParent();
                    while (parentCtx != null) {
                          if (parentCtx instanceof Java8Parser.MethodDeclarationContext) {
                               Java8Parser.MethodDeclarationContext methodCtx = (Java8Parser.MethodDeclarationContext) parentCtx;
                               enclosingMethod = methodCtx.methodHeader().methodDeclarator().Identifier().getText(); // Captura o nome do método ou assinatura
                               break;
                          }
                          parentCtx = parentCtx.getParent(); // Sobe um nível na árvore de análise
                    }
                    type = enclosingMethod + " : " + type;
                    // Adding variable information to the variable map, including the enclosing method
                    variablesMap.put(variableName, new Variable(enclosingMethod, accessModifier, importPackage, type, variableName, initialValue));
              }
         }
         
        @Override
        public void enterFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
             String type = ctx.unannType().getText();
             String importPackage = "com.test.Test";
             importPackage = JavaClasses.getClasses().get(type);
              
              if(importPackage != null){
                  //this variable uses the JavaClass type
              }else{
                  //this variable uses other... (RDKClasses)
              }
            
             ModifierAccess accessModifier = null;
             String initialValue = null;
             if (ctx.fieldModifier() != null && !ctx.fieldModifier().isEmpty()) {
                  String modify = ctx.fieldModifier(0).getText();
                  accessModifier = mapToModifierAccess(modify);
             }
             for (Java8Parser.VariableDeclaratorContext varCtx : ctx.variableDeclaratorList().variableDeclarator()) {
                  String variableName = varCtx.variableDeclaratorId().getText();
                  if (varCtx.variableInitializer() != null) {
                       initialValue = varCtx.variableInitializer().getText();
                  }
                  type = "global" + " : " + type;
                  variablesMap.put(variableName, new Variable("global", accessModifier, importPackage, type, variableName, initialValue));
                  //log += "\n" + "global" + ":" + variableName;
             }
        }
        private ModifierAccess mapToModifierAccess(String text) {
            switch (text) {
                case "private":
                     return ModifierAccess.PRIVATE;
                case "public":
                     return ModifierAccess.PUBLIC;
                case "protected":
                     return ModifierAccess.PROTECTED;
                default:
                     return ModifierAccess.DEFAULT;
            }
        }
        public String getCurrentMethod() {
             return JavaLanguage.currentMethod;
        }
        public void setCurrentMethod(String currentMethod) {
             JavaLanguage.currentMethod = currentMethod;
        }
    }
  
    public class Diagnostics {
        
        public AntlrListener diagnosticListener;
        public DiagnosticsContainer diagnostics;
        public boolean onSuccess = true;
        
        /*
        * Method used to check if the editor code has errors.
        * If so, the listener will be called.
        * This method must be called every time there is a change in the code. 
        */
        public void CheckforPossibleErrors(String inputText, int positionIndex) {
             if(diagnostics != null) diagnostics.reset();
                  Thread th = new Thread(() -> {
                       try {
                            ANTLRInputStream input = new ANTLRInputStream(inputText);
                            Java8Lexer lexer = new Java8Lexer(input);
                            CommonTokenStream tokens = new CommonTokenStream(lexer);
                            Java8Parser parser = new Java8Parser(tokens);
                            parser.removeErrorListeners();
                            parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
                            Java8ErrorListener rbkError = new Java8ErrorListener();
                            rbkError.getError(diagnosticListener);
                            parser.addErrorListener(rbkError);
                            Java8Parser.CompilationUnitContext compilationUnitContext = parser.compilationUnit();
                            // Create and add the custom listener
                            ParseTreeWalker walker = new ParseTreeWalker();
                            JavaListener compiler = new JavaListener(positionIndex);
                            walker.walk(compiler, compilationUnitContext);
                       } catch (Exception e) {
                            Log.e(TAG, "Error reading file", e);
                       }
                  });
                  th.setPriority(Thread.MIN_PRIORITY);
                  th.start();
        }
    }
}
