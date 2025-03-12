package org.robok.engine.defaults

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

import org.robok.engine.ui.screens.settings.about.models.Contributor

fun DefaultContributors() = listOf(
  Contributor(
    login = "Aquiles Trindade",
    role = "Founder",
    avatar_url = "https://github.com/trindadedev13.png",
  ),
  Contributor(
    login = "Thiarley Rocha",
    role = "Founder",
    avatar_url = "https://github.com/thdev-only.png",
  ),
)
