package org.robok.easyui.components

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

import org.robok.easyui.config.Config
import org.robok.easyui.internal.AttributeDefaults
import org.robok.easyui.internal.Utils.comment
import org.robok.easyui.internal.Utils.convertStyleToFileName
import org.robok.easyui.internal.newLine
import org.robok.easyui.internal.newLineBroken

class Components(
  private val codeComments: Boolean = false,
  private val verticalRoot: Boolean = false,
) {

  var indentLevel = 0
  val indent: String
    get() = "\t".repeat(indentLevel)

  val xmlCodeList: MutableList<String> = mutableListOf()
  val closingTagLayoutList: MutableList<String> = mutableListOf()
  var config: Config = Config(orientation = "portrait", style = "defaultStyle")

  fun rootView() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Opening Root Layout"))
    xmlCodeList.newLineBroken("""<?xml version="1.0" encoding="utf-8"?>""")
    xmlCodeList.newLineBroken("<LinearLayout")
    indentLevel++
    xmlCodeList.newLineBroken(AttributeDefaults.XMLNS(indent))
    xmlCodeList.newLineBroken("${indent}${AttributeDefaults.LAYOUT_HEIGHT}")
    xmlCodeList.newLineBroken("${indent}${AttributeDefaults.LAYOUT_WIDTH}")
    if (verticalRoot) xmlCodeList.newLineBroken("${indent}\tandroid:orientation=\"vertical\"")
    xmlCodeList.newLine("${indent}\tandroid:id=\"@+id/root_view\"")
    xmlCodeList.newLineBroken(">")
    indentLevel++
  }

  fun Column() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Opening Column Layout"))
    xmlCodeList.newLineBroken("${indent}<LinearLayout")
    indentLevel++
    xmlCodeList.newLineBroken("${indent}\tandroid:orientation=\"vertical\"")
    xmlCodeList.newLineBroken(">")
    indentLevel++
    closingTagLayoutList.newLine("Column:</LinearLayout>")
  }

  fun Row() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Opening Row Layout"))
    xmlCodeList.newLineBroken("${indent}<LinearLayout")
    indentLevel++
    xmlCodeList.newLineBroken("${indent}\tandroid:orientation=\"horizontal\"")
    xmlCodeList.newLineBroken(">")
    indentLevel++
    closingTagLayoutList.newLine("Row:</LinearLayout>")
  }

  fun Box() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Opening Box Layout"))
    xmlCodeList.newLineBroken("${indent}<RelativeLayout")
    indentLevel++
    xmlCodeList.newLineBroken(">")
    indentLevel++
    closingTagLayoutList.newLine("Box:</RelativeLayout>")
  }

  fun Text() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Text Component"))
    xmlCodeList.newLineBroken("${indent}<TextView")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "Text") +
        "\""
    )
    closingTagLayoutList.newLine("Text:/>")
  }

  fun Image() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Image Component"))
    xmlCodeList.newLineBroken("${indent}<ImageView")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "Image") +
        "\""
    )
    closingTagLayoutList.newLine("Image:/>")
  }

  fun CircleProgress() {
    if (codeComments) xmlCodeList.newLineBroken(comment("CircleProgress Component"))
    xmlCodeList.newLineBroken("${indent}<ProgressBar")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "CircleProgress") +
        "\""
    )
    closingTagLayoutList.newLine("CircleProgress:/>")
  }

  fun BarProgress() {
    if (codeComments) xmlCodeList.newLineBroken(comment("BarProgress Component"))
    xmlCodeList.newLineBroken("${indent}<ProgressBar")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "BarProgress") +
        "\""
    )

    xmlCodeList.newLineBroken("style=\"?android:attr/progressBarStyleHorizontal\"")

    closingTagLayoutList.newLine("BarProgress:/>")
  }

  fun Switch() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Switch Component"))
    xmlCodeList.newLineBroken("${indent}<Switch")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "Switch") +
        "\""
    )
    closingTagLayoutList.newLine("Switch:/>")
  }

  fun CheckBox() {
    if (codeComments) xmlCodeList.newLineBroken(comment("CheckBox Component"))
    xmlCodeList.newLineBroken("${indent}<CheckBox")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "CheckBox") +
        "\""
    )
    closingTagLayoutList.newLine("CheckBox:/>")
  }

  fun RadioGroup() {
    if (codeComments) xmlCodeList.newLineBroken(comment("RadioGroup Component"))
    xmlCodeList.newLineBroken("${indent}<RadioGroup")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "RadioGroup") +
        "\""
    )
    closingTagLayoutList.newLine("RadioGroup:/>")
  }

  fun RadioButton() {
    if (codeComments) xmlCodeList.newLineBroken(comment("RadioButton Component"))
    xmlCodeList.newLineBroken("${indent}<RadioButton")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "RadioButton") +
        "\""
    )
    closingTagLayoutList.newLine("RadioButton:/>")
  }

  fun Slider() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Slider Component"))
    xmlCodeList.newLineBroken("${indent}<SeekBar")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "Slider") +
        "\""
    )
    closingTagLayoutList.newLine("Slider:/>")
  }

  fun Button() {
    if (codeComments) xmlCodeList.newLineBroken(comment("Button Component"))
    xmlCodeList.newLineBroken("${indent}<Button")
    indentLevel++
    xmlCodeList.newLineBroken(
      "${indent}android:background=\"@drawable/" +
        convertStyleToFileName(config.style + "Button") +
        "\""
    )
    closingTagLayoutList.newLine("Button:/>")
  }

  /*
   * for test
   */
  fun MaterialButton() {
    if (codeComments) xmlCodeList.newLineBroken(comment("MaterialButton Component"))
    xmlCodeList.newLineBroken("${indent}<com.google.android.material.button.MaterialButton")
    indentLevel++
    closingTagLayoutList.newLine("com.google.android.material.button.MaterialButton:/>")
  }

  fun config() {
    /* its fake method*/
  }
}
