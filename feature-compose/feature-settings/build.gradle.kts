plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.about.libraries.plugin)
    alias(libs.plugins.compose.compiler)
    kotlin("plugin.serialization") version "2.0.20"
}

android {
    namespace = "org.gampiot.robok.feature.settings.compose"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
        targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
    }

    kotlinOptions {
        jvmTarget = libs.versions.android.jvm.get()
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.core.ktx)
    implementation(libs.datastore.preferences)
    implementation(libs.material)
     
    implementation(platform(libs.okhttp.bom))
    implementation("com.squareup.okhttp3:okhttp")
    
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    
    implementation(platform(libs.compose.bom))
    implementation(libs.material3.compose)
    implementation(libs.material.compose)
    implementation(libs.ui.compose)
    implementation(libs.ui.graphics.compose)
    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
    implementation(libs.viewmodel.compose)
    
    implementation(libs.about.libraries.core)
    implementation(libs.about.libraries.compose)
    implementation(libs.about.libraries.compose.m3)
    
    implementation(libs.coil.compose)
    implementation(libs.serialization.json)
    
    implementation(project(":feature:feature-res:strings"))
    implementation(project(":feature-compose:feature-component"))
}