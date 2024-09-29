/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "com.badlogic.gdx.backends.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
        targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
    }

    kotlinOptions {
        jvmTarget = libs.versions.android.jvm.get()
    }
}

dependencies {
    implementation(libs.material)
    implementation(libs.appcompat)
    implementation(libs.libgdx)
    implementation(project(":gdx-backend-android"))
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi-v7a")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86_64")

}