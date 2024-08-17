package org.gampiot.robok.feature.template.code.android.game.gui.screen

import android.os.Parcel
import android.os.Parcelable

import org.gampiot.robok.feature.template.code.rbk.RBKLayoutTemplate

class GameScreenLayoutTemplate : RBKLayoutTemplate {

    constructor() : super()

    constructor(parcel: Parcel) : super(parcel)

    override fun getName(): String {
        return "GameScreenLayoutTemplate"
    }

    override fun configure() {
        setContent(
            """
            GameScreenLayoutTemplate {
                Button(
                    id = "shoot_button",
                    text = "Shoot",
                    width = px(20),
                    height = px(20)
                )
            }
            """.trimIndent()
        )
    }

    companion object CREATOR : Parcelable.Creator<GameScreenLayoutTemplate> {
        override fun createFromParcel(parcel: Parcel): GameScreenLayoutTemplate {
            return GameScreenLayoutTemplate(parcel)
        }

        override fun newArray(size: Int): Array<GameScreenLayoutTemplate?> {
            return arrayOfNulls(size)
        }
    }
}

