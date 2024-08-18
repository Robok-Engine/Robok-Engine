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
            package ${getCodeClassPackageName()};

            import robok.game.screen.GameScreen;
            import robok.game.gui.GUIViewListener;
            import ${getCodeClassPackageName()}.datagui.MainGui;

            public class ${getCodeClassName()} extends GameScreen implements GUIViewListener {

                private MainGui views;

                @Override
                public void onScreenCreated() {
                    views = MainGui.inflate(this);
                    views.shootButton.setGUIViewListener(this);
                }
                
                @Override
                public void onClick(GUIView view) {
                    if (view == views.shootButton) {
                        
                    }
                }
            }
            """.trimIndent()
        )
    }
}

