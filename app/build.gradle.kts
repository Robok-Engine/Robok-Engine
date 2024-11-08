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

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.ByteArrayOutputStream
import org.robok.engine.build.BuildConfig
import org.robok.engine.build.CI

plugins {
  alias(libs.plugins.robok.application)
  alias(libs.plugins.robok.compose)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.about.libraries.plugin)
  id("kotlin-kapt")
  id("kotlin-parcelize")
}

android {
  namespace = BuildConfig.packageName
  
  defaultConfig {
    applicationId = BuildConfig.packageName
    vectorDrawables.useSupportLibrary = true
  }
    
  packaging {
    jniLibs.useLegacyPackaging = true
  }
    
  sourceSets {
    getByName("main") {
      jniLibs.srcDirs("src/main/jniLibs")
    }
  }
  
  compileOptions {
    isCoreLibraryDesugaringEnabled = true
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
    getByName("debug") {
      versionNameSuffix = "@${CI.commitHash}"
    }
  }
  
  signingConfigs {
    getByName("debug") {
      storeFile = file(layout.buildDirectory.dir("../testkey.keystore"))
      storePassword = "testkey"
      keyAlias = "testkey"
      keyPassword = "testkey"
    }
  }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.core.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.splashscreen)
    implementation(libs.datastore.preferences)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.serialization.json)
    
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)

    implementation(libs.glide)
    
    implementation(libs.material)

    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(platform(libs.compose.bom))
    implementation(libs.material3.compose)
    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
    implementation(libs.material.motion.compose.core)
    implementation(libs.material.icons.extended)
    
    implementation(libs.libgdx)
    implementation(libs.libgdx.backend.android)
    
    implementation(libs.sora.editor)
    
    implementation(libs.termux.terminal.view)
    implementation(libs.termux.terminal.emulator)
    
    implementation(libs.coil.compose)

    implementation(libs.gson)
    
    implementation(libs.about.libraries.core)
    implementation(libs.about.libraries.compose)
    implementation(libs.about.libraries.compose.m3)
    
    implementation(libs.insetter)
    
    // projects
    
    implementation(projects.appStrings)
    
    implementation(projects.feature.treeview)
    implementation(projects.feature.editor)
    implementation(projects.feature.modeling)
    implementation(projects.feature.xmlviewer)
    implementation(projects.feature.compiler)
    implementation(projects.feature.settings)
    
    implementation(projects.core.components)
    implementation(projects.core.utils)
    implementation(projects.core.antlr4.java)
    
    implementation(projects.robokEasyUi.gui)
}