package org.robok.engine.templates.xml

/*
 * Copyright 2025 Robok.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.robok.engine.templates.CodeTemplate

open class AndroidManifestTemplate : CodeTemplate() {

  override var name: String = "AndroidManifest"
  override var packageName: String = "org.robok.empty"
  override var extension: String = ".xml"

  var mainScreenName = "$packageName.MainScreen"
  var gameName = "Empty Game"

  override var code: String = generateCode()

  override fun regenerate() {
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
                android:label="$gameName" 
                android:theme="@style/Theme.Material3.DayNight.NoActionBar">
                
                <activity 
                  android:name="$mainScreenName" 
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
