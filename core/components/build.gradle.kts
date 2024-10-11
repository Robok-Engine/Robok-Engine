plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "org.robok.engine.core.components"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        compose = true
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
    
    implementation(platform(libs.compose.bom))
    implementation(libs.material3.compose)
    implementation(libs.material.compose)
    implementation(libs.ui.compose)
    implementation(libs.ui.graphics.compose)
    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
    implementation(libs.viewmodel.compose)
    
    implementation(project(":app-strings"))
}