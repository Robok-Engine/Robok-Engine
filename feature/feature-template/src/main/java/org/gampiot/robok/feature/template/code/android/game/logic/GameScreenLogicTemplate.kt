package org.gampiot.robok.feature.template.code.android.game.logic

import android.os.Parcel

import org.gampiot.robok.feature.template.code.CodeTemplate
import org.gampiot.robok.feature.template.code.java.JavaClassTemplate

open class GameScreenLogicTemplate : JavaClassTemplate {

    constructor() : super()

    constructor(parcel: Parcel) : super(parcel)

    override fun getName(): String {
        return "GameScreenLogicTemplate"
    }

    override fun configure() {
        setContent(
            """
            package $PACKAGE_NAME

            import robok.game.screen.GameScreen
            import robok.game.gui.GUIViewListener
            import $PACKAGE_NAME.datagui.MainGui

            class $CLASS_NAME : GameScreen(), GUIViewListener {

                private lateinit var views: MainGui

                override fun onScreenCreated() {
                    views = MainGui.inflate(this)
                    views.shootButton.setGUIViewListener(this)
                }

                override fun onClick(view: GUIView) {
                    if (view == views.shootButton) {
                        
                    }
                }
            }
            """.trimIndent()
        )
    }
}

