plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "org.robok.engine.feature.modeling"
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
    implementation(fileTree("libs") { include("*.jar") })
    
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    
    implementation(libs.libgdx)
    implementation(libs.libgdx.backend.android)
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi-v7a")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86_64")

    implementation(libs.google.gson)
    
    implementation(projects.core.utils)
}