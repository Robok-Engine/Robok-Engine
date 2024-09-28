plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
}

group = "org.gampiot.robok.feature.terminal"

android {
    namespace = "org.gampiot.robok.feature.terminal"
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
    implementation(libs.material)
    implementation(libs.appcompat)
    
    implementation(libs.gson)
    
    implementation("com.termux.termux-app:terminal-view:0.118.1")
    implementation("com.termux.termux-app:terminal-emulator:0.118.1")
    
    implementation(project(":core:core-utils"))
    implementation(project(":app-strings"))
    implementation(project(":core:core-components"))
    implementation(project(":easy-components"))
}