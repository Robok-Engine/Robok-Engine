package org.robok.engine.routes

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

sealed class SettingsRoutes(val route: String) {
    object Settings: SettingsRoutes("settings")
    object SettingsApp: SettingsRoutes("settings_app")
    object SettingsCodeEditor: SettingsRoutes("settings_codeeditor")
    object SettingsRDK: SettingsRoutes("settings/rdk")
    object About: SettingsRoutes("settings/about")
    object AboutLibraries: SettingsRoutes("settings/libraries")
}