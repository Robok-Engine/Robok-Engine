package org.robok.easyui.compiler.listener

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
 
import org.robok.easyui.antlr4.GUIParser.ArgumentContext
import org.robok.easyui.antlr4.GUIParser.ArgumentListContext
import org.robok.easyui.antlr4.GUIParser.ComponentContext
import org.robok.easyui.antlr4.GUIParser.GuiFileContext

import org.robok.easyui.GUIBuilder
import org.robok.easyui.antlr4.GUIBaseListener
import org.robok.easyui.internal.AttributeDefaults
 
class GUIParserListener(
  private val builder: GUIBuilder
): GUIBaseListener() {
  private var componentName: String? = null
     
  /** when finish the code */
  override fun exitGuiFile(context: GuiFileContext) {
    builder.finish()
    super.exitGuiFile(context)
  }
     
  /**
   * Called in start of component
   * Example:
   * Column { or Button(
   */
  override fun enterComponent(context: ComponentContext) {
    componentName = context.IDENTIFIER().text
    builder.runMethod(componentName)
  }
  
  /**
   * Called in end of component
   * Example
   * } or )
   */
  override fun exitComponent(context: ComponentContext) {
    if (context.text.endsWith("}")) {
      builder.closeBlockLayout()
      return
    }
    builder.closeBlockComponent()
  }
  
  /*
   * When entering a list of arguments (example: Button(text = "Click here"))
   */
  override fun enterArgumentList(context: ArgumentListContext) {
    var componentName = context.getParent().getChild(0).text
  }

  /*
   * When enter new argument (example text = "")
   */
  override fun enterArgument(context: ArgumentContext) {
    var key = AttributeDefaults.DEFAULT_KEY

    if (context.IDENTIFIER() != null) {
      key = context.IDENTIFIER().text
    } else {
      key = context.IDENTIFIER_COLON().text
    }

    var value = getAttributeValue(context)

    if (value.startsWith("\"") && value.endsWith("\"")) {
      value = value.substring(1, value.length - 1)
    }

    if (value.contains("\\\"")) {
      value = value.replace("\\\"", "&quot;")
    }

    builder.runMethodWithParameters(
      "addAttribute",
      componentName,
      key,
      value
    )
  }

  /*
   * Returns the attribute value (example: text = "A", this method will return A)
   */
  private fun getAttributeValue(context: ArgumentContext): String {
    var value = AttributeDefaults.DEFAULT_VALUE

    if (context.value().STRING() != null) {
      value = context.value().STRING().text
    } else if (context.value().NUMBER() != null) {
      value = context.value().NUMBER().text
    } else if (context.value().IDENTIFIER_DOT() != null) {
      value = context.value().IDENTIFIER_DOT().text
    }

    return value
  }
}