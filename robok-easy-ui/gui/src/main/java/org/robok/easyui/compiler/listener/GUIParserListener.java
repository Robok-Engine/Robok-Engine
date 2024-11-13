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

import static org.robok.easyui.antlr4.GUIParser.ArgumentContext;
import static org.robok.easyui.antlr4.GUIParser.ArgumentListContext;
import static org.robok.easyui.antlr4.GUIParser.ComponentContext;
import static org.robok.easyui.antlr4.GUIParser.GuiFileContext;

import org.robok.easyui.GUIBuilder;
import org.robok.easyui.antlr4.GUIBaseListener;
import org.robok.easyui.internal.AttributeDefaults;

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

  /*
   * When finish the code
   */
  @Override
  public void exitGuiFile(GuiFileContext ctx) {
    guiBuilder.finish();
    super.exitGuiFile(ctx);
  }

  /*
   * Detects the start of a layout (example: Column {)
   */
  @Override
  public void enterComponent(ComponentContext ctx) {
    this.componentName = ctx.IDENTIFIER().getText();
    guiBuilder.runMethod(componentName);
  }

  /*
   * Detects the closing of a layout (example:  })
   */
  @Override
  public void exitComponent(ComponentContext ctx) {
    if (ctx.getText().endsWith("}")) {
      guiBuilder.closeBlockLayout();
      return;
    }
    guiBuilder.closeBlockComponent();
  }

  /*
   * When entering a list of arguments (example: Button(text = "Click here"))
   */
  @Override
  public void enterArgumentList(ArgumentListContext ctx) {
    String componentName = ctx.getParent().getChild(0).getText();
  }

  /*
   * When enter new argument (example text = "")
   */
  @Override
  public void enterArgument(ArgumentContext ctx) {
    String key = AttributeDefaults.DEFAULT_KEY;

    if (ctx.IDENTIFIER() != null) {
      key = ctx.IDENTIFIER().getText();
    } else {
      key = ctx.IDENTIFIER_COLON().getText();
    }

    String value = getAttributeValue(ctx);

    if (value.startsWith("\"") && value.endsWith("\"")) {
      value = value.substring(1, value.length() - 1);
    }

    if (value.contains("\\\"")) {
      value = value.replaceAll("\\\"", "&quot;");
    }

    guiBuilder.runMethodWithParameters("addAttribute", componentName, key, value);
  }

  /*
   * Returns the attribute value (example: text = "A", this méthod will return A)
   */
  private String getAttributeValue(ArgumentContext ctx) {
    String value = AttributeDefaults.DEFAULT_VALUE;

    if (ctx.value().STRING() != null) {
      value = ctx.value().STRING().getText();

    } else if (ctx.value().NUMBER() != null) {
      value = ctx.value().NUMBER().getText();

    } else if (ctx.value().IDENTIFIER_DOT() != null) {
      value = ctx.value().IDENTIFIER_DOT().getText();
    }

    return value;
  }
}
