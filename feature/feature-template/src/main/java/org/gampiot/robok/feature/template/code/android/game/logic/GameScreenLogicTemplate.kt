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

            public class ${getCodeClassName()} extends GameScreen {

                @Override
                public void onScreenCreated() {
                    
                }
            }
            """.trimIndent()
        )
    }
}

