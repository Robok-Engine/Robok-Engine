plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "org.robok.lang"
    compileSdk = 35
    
    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
   
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
        targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
    }

    kotlinOptions {
        jvmTarget = libs.versions.android.jvm.get()
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "18"
}

dependencies { }
