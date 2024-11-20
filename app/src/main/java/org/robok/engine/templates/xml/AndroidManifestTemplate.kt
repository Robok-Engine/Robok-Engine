package org.robok.engine.templates.xml

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

import org.robok.engine.templates.CodeTemplate

open class AndroidManifestTemplate : CodeTemplate() {

  override var name: String = "AndroidManifest"
  override var packageName: String = "org.robok.empty"
  override var extension: String = ".xml"

  private var mainActivityPackage = "$packageName.MainScreen"

  override var code: String = generateCode()

  override fun regenerate() {
    mainActivityPackage = "$packageName.MainScreen"
    code = generateCode()
  }

  private fun generateCode(): String {
    return """
            <?xml version="1.0" encoding="utf-8"?>
            <manifest 
              xmlns:android="http://schemas.android.com/apk/res/android"
              package="$packageName">
              
              <application 
                android:icon="@drawable/ic_launcher" 
                android:roundIcon="@drawable/ic_launcher" 
                android:label="@string/app_name" 
                android:theme="@style/Theme.Material3.DayNight.NoActionBar">
                
                <activity 
                  android:name="$mainActivityPackage" 
                  android:exported="true">
                  
                  <intent-filter>
                    <action 
                      android:name="android.intent.action.MAIN" />
                    <category 
                      android:name="android.intent.category.LAUNCHER" />
                  </intent-filter>
                </activity>
              </application>
            </manifest>
        """
      .trimIndent()
  }
}
