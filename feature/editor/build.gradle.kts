plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    kotlin("plugin.serialization") version "2.1.0"
}

android {
    namespace = "org.robok.engine.feature.editor"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
    implementation(libs.google.material)
    implementation(libs.androidx.appcompat) 
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.datastore.preferences)
    
    implementation(libs.ktx.coroutines.android)
    implementation(libs.ktx.serialization.json)
    
    implementation(libs.koin.android)
    
    implementation(libs.sora.editor)
    implementation(libs.sora.editor.language.java)
    implementation(libs.sora.editor.language.textmate)
    
    implementation(libs.antlr4)
    implementation(libs.antlr4.runtime)
    
    implementation(projects.appStrings)
    implementation(projects.core.settings)
    implementation(projects.core.utils)
    implementation(projects.core.antlr4.java)
}
