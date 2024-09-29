plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "org.gampiot.robok.feature.modeling"
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
    implementation(fileTree("libs") { include("*.jar") })
    
    implementation(libs.appcompat)
    implementation(libs.material)
    
    implementation(platform(libs.compose.bom))
    implementation(libs.material3.compose)
    implementation(libs.material.compose)
    implementation(libs.ui.compose)
    implementation(libs.ui.graphics.compose)
    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
    implementation(libs.viewmodel.compose)
    
    implementation(libs.libgdx)
    implementation(project(":gdx-backend-android"))
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi-v7a")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86_64")

    implementation(libs.gson)
    
    implementation(project(":core:core-utils"))
}
