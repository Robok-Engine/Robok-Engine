package org.robok.engine.core.templates.code.android.game.gui.screen

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

import android.os.Parcel
import android.os.Parcelable
import org.robok.engine.core.templates.code.rbk.RBKLayoutTemplate

open class GameScreenLayoutTemplate : RBKLayoutTemplate {

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
            """
                .trimIndent()
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
