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
import org.robok.easyui.components.Components
import org.robok.easyui.config.Config
import org.robok.easyui.converter.AttributeConverter
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

    var attributeConverter: AttributeConverter? = null

    private var orientation: String = "portrait"
    private var style: String = "defaultStyle"
    private var isConfigEnable = false
    private var components: Components = Components(codeComments, verticalRoot)

    init {
        components.rootView()
        attributeConverter = AttributeConverter()
    }

    fun newLog(log: String) {
        if (codeComments) components.xmlCodeList.newLine(log)
    }

    fun closeBlockComponent() {
        if (isConfigEnable) {
            isConfigEnable = false
            return
        }

        if (components.closingTagLayoutList.isNotEmpty()) {
            /* if (components.closingTagLayoutList.last().equals(Config.getName())) {
                components.xmlCodeList.newLineBroken(comment("It's here"))
                config = Config(orientation = orientation, style = style)
                components.closingTagLayoutList.removeAt(components.closingTagLayoutList.size - 1)
                return
            }else{
                components.xmlCodeList.newLineBroken(comment("last is: " + components.closingTagLayoutList.last()))
            }*/
            val tags = components.closingTagLayoutList.last().split(":")

            if (tags.size >= 2) {
                val closingTagGui = tags[0]
                val closingTagXml = tags[1]

                if (codeComments)
                    components.xmlCodeList.newLineBroken(comment("Closing $closingTagGui Layout"))

                if (closingTagXml.equals("/>")) {
                    var previousAttribute: String = components.xmlCodeList.last()
                    if (previousAttribute.contains("\n"))
                        previousAttribute = previousAttribute.replace("\n", "")

                    components.xmlCodeList.removeAt(components.xmlCodeList.size - 1)
                    components.xmlCodeList.newLineBroken(previousAttribute + closingTagXml)
                }
                components.indentLevel--
                components.closingTagLayoutList.removeAt(components.closingTagLayoutList.size - 1)
            } else {
                onError("Error: invalid tag format  tag of closing.")
            }
        } else {
            onError("Error: No layout to close in closeBlockComponent.")
        }
    }

    fun closeBlockLayout() {
        if (components.closingTagLayoutList.isNotEmpty()) {
            val tags = components.closingTagLayoutList.last().split(":")

            if (tags.size >= 2) {
                val closingTagGui = tags[0]
                val closingTagXml = tags[1]

                if (codeComments)
                    components.xmlCodeList.newLineBroken(comment("Closing $closingTagGui Layout"))

                components.xmlCodeList.newLineBroken("${components.indent}$closingTagXml" + "\n")
                components.indentLevel--
                components.closingTagLayoutList.removeAt(components.closingTagLayoutList.size - 1)
            } else {
                onError("Error: invalid tag format  tag of closing.")
            }
        } else {
            onError("Error: No layout to close in closeBlockLayout.")
        }
    }

    fun runMethod(methodName: String) {
        try {
            val method = Components::class.java.getDeclaredMethod(methodName)
            method.invoke(components)
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
            /*if (!components.closingTagLayoutList.last().equals(methodName))
            components.closingTagLayoutList.newLine(methodName)*/

            when (key) {
                "orientation" -> orientation = value
                "style" -> style = value
            }

            components.config = Config(orientation = orientation, style = style)
            isConfigEnable = true
            return
        }

        if (components.xmlCodeList.get((components.xmlCodeList.size - 1)).contains("/>")) {
            containsCloseTag = true
            attribute = components.xmlCodeList.last().replace("/>", "").replace("\n", "")
            components.xmlCodeList.removeAt(components.xmlCodeList.size - 1)
            components.xmlCodeList.newLineBroken(attribute)
            components.indentLevel++
        }

        if (components.xmlCodeList.get((components.xmlCodeList.size - 1)).contains(">")) {
            containsSingleCloseTag = true
            components.xmlCodeList.removeAt(components.xmlCodeList.size - 1)
        }

        components.indentLevel++
        val attributeConverted = attributeConverter?.convert(key)
        components.xmlCodeList.newLineBroken(
            components.indent + attributeConverted + "=" + "\"$value\""
        )
        components.indentLevel--

        if (containsCloseTag) {
            components.closingTagLayoutList.newLine("$methodName:/>")
            closeBlockComponent()
        }

        if (containsSingleCloseTag) {
            components.xmlCodeList.newLineBroken(">")
        }
    }

    fun buildXML(): String {
        var codes: StringBuilder = StringBuilder()

        components.xmlCodeList.forEach { codes.append(it) }

        return codes.toString()
    }

    fun finish() {
        components.indentLevel--
        components.indentLevel--
        if (codeComments) components.xmlCodeList.newLineBroken(comment("Closing Root Layout"))
        components.xmlCodeList.newLineBroken("</LinearLayout>")
        if (codeComments) components.xmlCodeList.newLine("\n" + comment("End."))
        onGenerateCode(buildXML(), components.config)
        Log.d(TAG, components.config.toString())
    }
}
