plugins {
    id("com.android.application")
    id("kotlin-android")
}

def app_version ="v1.0.0"

android {
    namespace = "com.trindade.gamide"
    compileSdk = 34
    
    defaultConfig {
        applicationId = "com.trindade.gamide"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = app_version

        vectorDrawables { 
            useSupportLibrary = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "GIT_HASH", "${app_version}" + "-Release")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            buildConfigField("String", "GIT_HASH", "${app_version}" + "-Debug")
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    
    implementation(project(":gslang"))
}