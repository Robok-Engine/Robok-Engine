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
package com.example.soraeditortest.langs.java;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.example.compiler2.Java8BaseListener;
import com.example.compiler2.Java8ErrorListener;
import com.example.compiler2.Java8Lexer;
import com.example.compiler2.Java8Parser;
import com.example.soraeditortest.SrcCodeEditor;
import io.github.rosemoe.sora.event.ContentChangeEvent;
import io.github.rosemoe.sora.lang.completion.CompletionItem;
import io.github.rosemoe.sora.lang.completion.CompletionItemKind;
import io.github.rosemoe.sora.lang.diagnostic.DiagnosticsContainer;
import io.github.rosemoe.sora.widget.CodeEditor;
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
import com.example.soraeditortest.autocomplete.IdentifierAutoComplete;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import io.github.rosemoe.sora.lang.completion.SimpleCompletionItem;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.soraeditortest.langs.java.object.ModifiersAcess;

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
public class JavaLanguage implements Language {

    private final static CodeSnippet FOR_SNIPPET = CodeSnippetParser.parse("for(int ${1:i} = 0;$1 < ${2:count};$1++) {\n    $0\n}");
    private final static CodeSnippet STATIC_CONST_SNIPPET = CodeSnippetParser.parse("private final static ${1:type} ${2/(.*)/${1:/upcase}/} = ${3:value};");
    private final static CodeSnippet CLIPBOARD_SNIPPET = CodeSnippetParser.parse("${1:${CLIPBOARD}}");

    private IdentifierAutoComplete identifierAutoComplete;
    private final JavaIncrementalAnalyzeManager manager;
    private final JavaQuoteHandler javaQuoteHandler = new JavaQuoteHandler();
    public static String log = "";
    public static HashMap<String, Variable> variables;
    public static HashMap<String, Method> methods;
    JavaLanguage.Diagnostics diagnostics;
    
    
    //Code Editor
    private CodeEditor editor;
    
    //cursor
    private int cursorIndex;
    
    //String do metodo editando
    private static String currentMethod = null;
    
    public static String inputText = "";
    
    public JavaLanguage(CodeEditor editor, Java8ErrorListener.ErrorDiagnostico errorListener, DiagnosticsContainer diagnosticsContainer) {
        identifierAutoComplete = new IdentifierAutoComplete(JavaTextTokenizer.sKeywords);
        manager = new JavaIncrementalAnalyzeManager();
        variables = new HashMap<>();
        methods = new HashMap<>();
        this.editor = editor;
        subscribeEventEditor();
        diagnostics = new JavaLanguage.Diagnostics();
        
        diagnostics.errorListener = errorListener;
        diagnostics.diagnostics = diagnosticsContainer;
        start();
     //   JavaLanguage.variablesTypes.put("up", "String");
    }
    
    private void subscribeEventEditor(){
        
        editor.subscribeEvent(ContentChangeEvent.class, (event, undubscribe) -> {
                
                this.inputText = editor.getText().toString();
              //  String inputText = editor.getText().toString(); //Gets the text from the editor
                    
                        
             //   CheckforPossibleErrors(inputText, errorListener);
        
    });
        }

  private Runnable runnable; // Definindo o Runnable como uma variável de classe para controle
  Handler handler = new Handler(Looper.getMainLooper());
  private void start() {
    runnable =
        new Runnable() {
          @Override
          public void run() {
            // Sua lógica a ser repetida
            if (diagnostics.onSucess) {
              diagnostics.CheckforPossibleErrors(inputText, cursorIndex);
            }

            // Reagendar o runnable para ser executado novamente após 4 segundos
            handler.postDelayed(this, 1000);
          }
        };

    // Agendar o runnable para ser executado pela primeira vez após 15 milissegundos
    handler.postDelayed(runnable, 15);
  }

    @NonNull
    @Override
    public AnalyzeManager getAnalyzeManager() {
        return manager;
    }

    @Nullable
    @Override
    public QuickQuoteHandler getQuickQuoteHandler() {
        return javaQuoteHandler;
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
    public void requireAutoComplete(@NonNull ContentReference content, @NonNull CharPosition position,
                                    @NonNull CompletionPublisher publisher, @NonNull Bundle extraArguments) {

        /*prefix: contém o texto da linha atual em partes, tipo String
          content: contém o texto de todas as linhas, parece ser um StringBuilder
          position: contém as posições do caractere, linha, coluna, index, tipo CharPosition
        */

        var prefix =
                CompletionHelper.computePrefix(
                        content, position, MyCharacter::isJavaIdentifierPart);
        final var idt = manager.identifiers;

        // Nova variável para armazenar a linha inteira onde o cursor está localizado
        int lineIndex = position.getLine(); // obtém o índice da linha atual a partir da posição
        String currentLine = content.getLine(lineIndex).toString(); // obtém o conteúdo da linha

        // Agora você tem duas variáveis:
        // 'prefix' contém a palavra que termina no cursor
        // 'currentLine' contém todo o conteúdo da linha onde o cursor está localizado
        cursorIndex = position.getIndex(); // índice do cursor no texto completo
        
        inputText = content.toString(); //Gets the text from the editor
        //  log = inputText;          
        
        //log = methods.toString();
                        
        if (idt != null) {
            //Variables : hashmap de variaveis
            //CurrentIndex: index do cursor
            //CurrentMethod: nome do metodo one es esta editando
           identifierAutoComplete.setVariables(variables);
           identifierAutoComplete.setMethods(methods);
           identifierAutoComplete.requireAutoComplete(content, currentLine, position,prefix, publisher, idt, currentMethod);
            
        }
            //Toast.makeText(SrcCodeEditor.context, "test ", Toast.LENGTH_LONG).show();
      /*  List<CompletionItem> result = new ArrayList<>();
        for(Method method : methods.values()){
            
            //Method method = methods.get(title);
          //  String[] parts = title.split(":");
            
            
        result.add(new SimpleCompletionItem(method.getName(), method.getReturnType(), 2, "test")
                            .kind(CompletionItemKind.Color));
        }*/
        /*
        List<CompletionItem> result = new ArrayList<>();
        result.add(new SimpleCompletionItem("a " + currentMethod, "keyword", 2, "test")
                            .kind(CompletionItemKind.Variable));*/
        /*result.add(new SimpleCompletionItem("String", "class", 2, "Stringg")
                            .kind(CompletionItemKind.Class));
        result.add(new SimpleCompletionItem("StringBuilder", "class", 2, "StringBuilder")
                            .kind(CompletionItemKind.Class));*/
        
        //publisher.addItems(result);
        
       /* 
        
        */
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

    class BraceHandler implements NewlineHandler {

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
            
           // variablesTypes.put(name, type);
        }
    }

  public static class JavaListener extends Java8BaseListener {
        
        private int cursorIndex;
        
        public JavaListener(int positionIndex){
            this.cursorIndex = positionIndex;
            JavaLanguage.currentMethod = null;
            variables.clear();
            methods.clear();
            
          //  log = "";
        }
        
        @Override
    public void enterMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        // Verifica se o cursor está dentro do método
        if (ctx.start.getStartIndex() <= cursorIndex && ctx.stop.getStopIndex() >= cursorIndex) {
            JavaLanguage.currentMethod = ctx.methodHeader().methodDeclarator().Identifier().getText();
        }
            
        // Capturando o modificador de acesso
        List<Java8Parser.MethodModifierContext> accessModifiers = null;// Presume 'default' se nenhum modificador estiver presente
        if (ctx.methodModifier() != null && !ctx.methodModifier().isEmpty()) {
            accessModifiers = ctx.methodModifier();
        }

        // Capturando o tipo de retorno do método
        String returnType = ctx.methodHeader().result().getText();

        // Capturando o nome do método
        String methodName = ctx.methodHeader().methodDeclarator().Identifier().getText();

        // Capturando os parâmetros do método
        List<String> parameters = new ArrayList<>();
        if (ctx.methodHeader().methodDeclarator().formalParameterList() != null) {
            Java8Parser.FormalParameterListContext paramListCtx = ctx.methodHeader().methodDeclarator().formalParameterList();
            // Capturando os parâmetros normais
            if (paramListCtx.formalParameters() != null) {
                for (Java8Parser.FormalParameterContext paramCtx : paramListCtx.formalParameters().formalParameter()) {
                    String paramType = paramCtx.unannType().getText();
                    String paramName = paramCtx.variableDeclaratorId().getText();
                    parameters.add(paramType + " " + paramName);
                }
            }
            // Capturando o último parâmetro (pode ser varargs ou um parâmetro normal)
            if (paramListCtx.lastFormalParameter() != null) {
                if (paramListCtx.lastFormalParameter().formalParameter() != null) {
                    // Parâmetro normal final
                    Java8Parser.FormalParameterContext lastParamCtx = paramListCtx.lastFormalParameter().formalParameter();
                    String paramType = lastParamCtx.unannType().getText();
                    String paramName = lastParamCtx.variableDeclaratorId().getText();
                    parameters.add(paramType + " " + paramName);
                } else if (paramListCtx.lastFormalParameter().formalParameter().variableDeclaratorId() != null) {
                    // Parâmetro de varargs
                    Java8Parser.LastFormalParameterContext varArgsCtx = paramListCtx.lastFormalParameter();
                    String paramType = varArgsCtx.unannType().getText() + "...";
                    String paramName = varArgsCtx.variableDeclaratorId().getText();
                    parameters.add(paramType + " " + paramName);
                }
            }
        }
            
           // log = parameters.toString();
            
            Method method = new Method(accessModifiers, returnType, methodName, parameters);
            
            methods.put(methodName, method);
            
            log = "ggg";
            
    }

   @Override
public void enterLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext ctx) {
    // Capturando o tipo da variável
    String type = ctx.unannType().getText();
    ModifiersAcess accessModifier = null;
    String initialValue = null;
    String enclosingMethod = null; // Adiciona a variável para armazenar o método ou bloco envolvente
    
    // Tentando capturar o modificador de acesso, se existir
    if (ctx.variableModifier() != null && !ctx.variableModifier().isEmpty()) {
        String modify = ctx.variableModifier(0).getText();
                
        accessModifier = mapToModifierAccess(modify);
    }

    // Capturando o nome da variável e o valor inicial
    for (Java8Parser.VariableDeclaratorContext varCtx : ctx.variableDeclaratorList().variableDeclarator()) {
        String variableName = varCtx.variableDeclaratorId().getText();

        if (varCtx.variableInitializer() != null) {
            initialValue = varCtx.variableInitializer().getText();
        }

        // Determinando o método ou bloco de código onde a variável está declarada
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
        // Adicionando informações da variável ao mapa de variáveis, incluindo o método envolvente
        variables.put(enclosingMethod + ":" + variableName, new Variable(accessModifier, type, variableName, initialValue));
       // log += "\n" + enclosingMethod + ":" + variableName;
    }

            }


        @Override
    public void enterFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {
        // Captura de variáveis de classe
        String type = ctx.unannType().getText();
        ModifiersAcess accessModifier = null;
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

            variables.put("global" + ":" + variableName, new Variable(accessModifier, type, variableName, initialValue));
                //log += "\n" + "global" + ":" + variableName;
        }
    }

    // / Método para mapear texto para o enum ModifierAccess
    private ModifiersAcess mapToModifierAccess(String text) {
        switch (text) {
            case "private":
                return ModifiersAcess.PRIVATE;
            case "public":
                return ModifiersAcess.PUBLIC;
            case "protected":
                return ModifiersAcess.PROTECTED;
            default:
                return ModifiersAcess.DEFAULT;
        }
    }


            public String getCurrentMethod() {
                return JavaLanguage.currentMethod;
            }
            public void setCurrentMethod(String currentMethod) {
                JavaLanguage.currentMethod = currentMethod;
            }}
    
    
    public static class Diagnostics {
        
        public Java8ErrorListener.ErrorDiagnostico errorListener;
        DiagnosticsContainer diagnostics;
        public boolean onSucess= true;
        /*Method used to check if the editor code has errors.
    If so, the listener will be called.*/
    //This method must be called every time there is a change in the code.
    //Esse metodo devera ser chamado toda vez que houver uma modificação no codigo.
    public void CheckforPossibleErrors(String inputText, int positionIndex) {
        if(diagnostics != null) diagnostics.reset();
            
        Thread th = new Thread(() -> {
                
        try {
    // Código a ser executado na nova thread
            //Using antlr to compile the code.
            ANTLRInputStream input = new ANTLRInputStream(inputText);
            Java8Lexer lexer = new Java8Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Java8Parser parser = new Java8Parser(tokens);
            parser.removeErrorListeners();
            parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
            Java8ErrorListener roboError = new Java8ErrorListener();

            roboError.getError(errorListener);
                    
            parser.addErrorListener(roboError);
            
            //parser.compilationUnit();
            
            Java8Parser.CompilationUnitContext compilationUnitContext = parser.compilationUnit();

        // Crie e adicione o listener personalizado
        ParseTreeWalker walker = new ParseTreeWalker();
        JavaListener compiler = new JavaListener(positionIndex);
                        
        walker.walk(compiler, compilationUnitContext);
            
           // parser.program(); // Start the analysis from the 'program' rule
            // Use ParseTreeWalker to navigate the tree and apply checks 
            //additional if necessary
        } catch (Exception e) {
            Log.e("MainActivity", "Error reading file", e);
        }
        
        });
        th.setPriority(Thread.MIN_PRIORITY);
        
        th.start();
        
        }
    }
}
