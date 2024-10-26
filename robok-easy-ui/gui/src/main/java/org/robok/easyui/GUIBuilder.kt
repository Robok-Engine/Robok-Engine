package org.robok.easyui

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

import android.content.Context
import android.util.Log
import java.lang.reflect.InvocationTargetException
import org.robok.easyui.config.Config
import org.robok.easyui.converter.AttributeConverter
import org.robok.easyui.internal.DefaultValues
import org.robok.easyui.internal.Utils.comment
import org.robok.easyui.internal.newLine
import org.robok.easyui.internal.newLineBroken

/*
 * Class that generates XML from the received data.
 */

class GUIBuilder(
    private val context: Context,
    private val onGenerateCode: (String, Config) -> Unit,
    val onError: (String) -> Unit,
    private val codeComments: Boolean = false,
    private val verticalRoot: Boolean = false,
) {
    companion object {
        private const val TAG = "GUIBuilder"
    }

    val xmlCodeList: MutableList<String> = mutableListOf()
    private var indentLevel = 0
    private val indent: String
        get() = "\t".repeat(indentLevel)

    val closingTagLayoutList: MutableList<String> = mutableListOf()
    var attributeConverter: AttributeConverter? = null

    private var orientation: String = ""
    private var style: String = ""
    private var config: Config = Config(orientation = "portrait", style = "defaultStyle")

    init {
        rootView()
        attributeConverter = AttributeConverter()
    }

    private fun rootView() {
        if (codeComments) xmlCodeList.newLineBroken(comment("Opening Root Layout"))
        xmlCodeList.newLineBroken("""<?xml version="1.0" encoding="utf-8"?>""")
        xmlCodeList.newLineBroken("<LinearLayout")
        indentLevel++
        xmlCodeList.newLineBroken(DefaultValues.XMLNS(indent))
        xmlCodeList.newLineBroken("${indent}${DefaultValues.LAYOUT_HEIGHT}")
        xmlCodeList.newLineBroken("${indent}${DefaultValues.LAYOUT_WIDTH}")
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

    fun Text() {
        if (codeComments) xmlCodeList.newLineBroken(comment("Text Component"))
        xmlCodeList.newLineBroken("${indent}<TextView")
        indentLevel++
        xmlCodeList.newLineBroken(
            "${indent}android:drawable=\"@drawable/" +
                config.convertStyleToFileName(config.style + "Text") +
                "\""
        )
        closingTagLayoutList.newLine("Text:/>")
    }

    fun Button() {
        if (codeComments) xmlCodeList.newLineBroken(comment("Button  Component"))
        xmlCodeList.newLineBroken("${indent}<Button")
        indentLevel++
        xmlCodeList.newLineBroken(
            "${indent}android:drawable=\"@drawable/" +
                config.convertStyleToFileName(config.style + "Button") +
                "\""
        )
        closingTagLayoutList.newLine("Button:/>")
    }

    fun config() {
        /* its fake method*/
    }

    fun newLog(log: String) {
        if (codeComments) xmlCodeList.newLine(log)
    }

    fun closeBlockComponent() {
        if (closingTagLayoutList.isNotEmpty()) {
            if (closingTagLayoutList.last().equals(Config.getName())) {
                config = Config(orientation = orientation, style = style)
                closingTagLayoutList.removeAt(closingTagLayoutList.size - 1)
                return
            }
            val tags = closingTagLayoutList.last().split(":")

            if (tags.size >= 2) {
                val closingTagGui = tags[0]
                val closingTagXml = tags[1]

                if (codeComments)
                    xmlCodeList.newLineBroken(comment("Closing $closingTagGui Layout"))

                if (closingTagXml.equals("/>")) {
                    var previousAttribute: String = xmlCodeList.last()
                    if (previousAttribute.contains("\n"))
                        previousAttribute = previousAttribute.replace("\n", "")

                    xmlCodeList.removeAt(xmlCodeList.size - 1)
                    xmlCodeList.newLineBroken(previousAttribute + closingTagXml)
                }
                indentLevel--
                closingTagLayoutList.removeAt(closingTagLayoutList.size - 1)
            } else {
                onError("Error: invalid tag format  tag of closing.")
            }
        } else {
            onError("Error: No layout to close.")
        }
    }

    fun closeBlockLayout() {
        if (closingTagLayoutList.isNotEmpty()) {
            val tags = closingTagLayoutList.last().split(":")

            if (tags.size >= 2) {
                val closingTagGui = tags[0]
                val closingTagXml = tags[1]

                if (codeComments)
                    xmlCodeList.newLineBroken(comment("Closing $closingTagGui Layout"))

                xmlCodeList.newLineBroken("${indent}$closingTagXml" + "\n")
                indentLevel--
                closingTagLayoutList.removeAt(closingTagLayoutList.size - 1)
            } else {
                onError("Error: invalid tag format  tag of closing.")
            }
        } else {
            onError("Error: No layout to close.")
        }
    }

    fun runMethod(methodName: String) {
        try {
            val method = this::class.java.getDeclaredMethod(methodName)
            method.invoke(this)
        } catch (e: InvocationTargetException) {
            onError("runMethod: " + e.toString())
        }
    }

    fun runMethodWithParameters(methodName: String, vararg args: Any?) {
        try {
            val parameterTypes = args.map { it?.javaClass }.toTypedArray()
            val method = this::class.java.getDeclaredMethod(methodName, *parameterTypes)
            method.invoke(this, *args)
        } catch (e: NoSuchMethodException) {

            onError(e.toString())
        } catch (e: InvocationTargetException) {
            val originalException = e.cause
            onError(e.toString())
        } catch (e: IllegalAccessException) {
            onError(e.toString())
        }
    }

    fun addAttribute(methodName: String, key: String, value: String) {
        var containsCloseTag = false
        var containsSingleCloseTag = false
        var attribute = ""

        if (methodName.equals(Config.getName())) {
            if (!closingTagLayoutList.last().equals(methodName))
                closingTagLayoutList.newLine(methodName)
            when (key) {
                "orientation" -> orientation = value
                "style" -> style = value
            }
            return
        }

        if (xmlCodeList.get((xmlCodeList.size - 1)).contains("/>")) {
            containsCloseTag = true
            attribute = xmlCodeList.last().replace("/>", "").replace("\n", "")
            xmlCodeList.removeAt(xmlCodeList.size - 1)
            xmlCodeList.newLineBroken(attribute)
            indentLevel++
        }

        if (xmlCodeList.get((xmlCodeList.size - 1)).contains(">")) {
            containsSingleCloseTag = true
            xmlCodeList.removeAt(xmlCodeList.size - 1)
        }

        indentLevel++
        val attributeConverted = attributeConverter?.convert(key)
        xmlCodeList.newLineBroken(indent + attributeConverted + "=" + "\"$value\"")
        indentLevel--

        if (containsCloseTag) {
            closingTagLayoutList.newLine("$methodName:/>")
            closeBlockComponent()
        }

        if (containsSingleCloseTag) {
            xmlCodeList.newLineBroken(">")
        }
    }

    fun buildXML(): String {
        var codes: StringBuilder = StringBuilder()

        xmlCodeList.forEach { codes.append(it) }

        return codes.toString()
    }

    fun finish() {
        indentLevel--
        indentLevel--
        if (codeComments) xmlCodeList.newLineBroken(comment("Closing Root Layout"))
        xmlCodeList.newLineBroken("</LinearLayout>")
        if (codeComments) xmlCodeList.newLine("\n" + comment("End."))
        onGenerateCode(buildXML(), config)
        Log.d(TAG, config.toString())
    }
}
