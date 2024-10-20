package org.robok.easyui.compiler.listener;

/*
 *  This file is part of Robok © 2024.
 *
 *  Robok is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Robok is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with Robok.  If not, see <https://www.gnu.org/licenses/>.
 */

import static org.robok.easyui.antlr4.GUIParser.GuiFileContext;
import static org.robok.easyui.antlr4.GUIParser.ComponentContext;
import static org.robok.easyui.antlr4.GUIParser.ArgumentContext;
import static org.robok.easyui.antlr4.GUIParser.ArgumentListContext;
import org.robok.easyui.antlr4.GUIBaseListener;

import org.robok.easyui.GUIBuilder;
import org.robok.easyui.internal.Utils;

import java.lang.reflect.Method;

/*
 * Class that identifies the code and uses the { @link GUIBuilder } to generate de the.
 * @author Thiarley Rocha (ThDev-only).
 */

public class GUIParserListener extends GUIBaseListener {

    private GUIBuilder guiBuilder;
    private String componentName;

    public GUIParserListener(GUIBuilder guiBuilder) {
        this.guiBuilder = guiBuilder;
    }

    @Override
    public void exitGuiFile(GuiFileContext ctx) {
        guiBuilder.finish();
        super.exitGuiFile(ctx);
    }

    // Detecta o início de um layout (ex: Column {)
    @Override
    public void enterComponent(ComponentContext ctx) {
        String componentName = ctx.IDENTIFIER().getText();
        if (ctx.getText().contains("{")) {
            guiBuilder.runMethod(componentName);
            // runMethodWithParams("enterLayout", componentName);  // Chama o método específico para
            // layouts ao abrir {
        } else {
            guiBuilder.runMethod(componentName);
            this.componentName = componentName;
        }
    }

    // Detecta o fechamento de um layout (ex: })
    @Override
    public void exitComponent(ComponentContext ctx) {
        if (ctx.getText().endsWith("}")) {
            guiBuilder.newLog(Utils.comment("Layout is closing"));
            guiBuilder.runMethod("closeBlockLayout");
        }else guiBuilder.runMethod("closeBlockComponent");
        
    }

    // Ao entrar em uma lista de argumentos (ex: Button(text = "Click here"))
    @Override
    public void enterArgumentList(ArgumentListContext ctx) {
        String componentName = ctx.getParent().getChild(0).getText();
        // runMethodWithParams("runMethodArguments", componentName);
    }
    
    @Override
    public void enterArgument(ArgumentContext ctx) {
        String key;
        if (ctx.IDENTIFIER() != null) {
            key = ctx.IDENTIFIER().getText();
        } else {
            key = ctx.IDENTIFIER_COLON().getText();
        }
        String value = getValue(ctx);
        if (value.startsWith("\"") && value.endsWith("\"")) {
            value = value.substring(1, value.length() - 1);
        }
        if (value.contains("\\\"")) {
            value = value.replaceAll("\\\"", "&quot;");
        }
        guiBuilder.runMethodWithParameters("addAttribute", componentName, key, value);
    }

public String getValue(ArgumentContext ctx){
    String value = "null";

    if(ctx.value().STRING() != null){
        value = ctx.value().STRING().getText();
        
    }else if(ctx.value().NUMBER() != null){
        value = ctx.value().NUMBER().getText();
        
    }else if(ctx.value().IDENTIFIER_DOT() != null){
        value = ctx.value().IDENTIFIER_DOT().getText();
        
    }

    return value;
}
}