package org.robok.easyui.converter

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

object AttributesAbbreviations {
  public val attributes: Map<String, String> =
    mapOf(
      "layout:an:bm" to "android:layout_alignParentBottom",
      "layout:an:be" to "android:layout_alignBaseline",
      "layout:gravity:cr:hl" to "android:layout_centerHorizontal",
      "layout:gravity:cr:vl" to "android:layout_centerVertical",
      "layout:an:st" to "android:layout_alignParentStart",
      "layout:an:tp" to "android:layout_alignParentTop",
      "layout:an:ed" to "android:layout_alignParentEnd",
    )

  public fun convert(attribute: String): String? {
    return attributes[attribute]
  }
}
