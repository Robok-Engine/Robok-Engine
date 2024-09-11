plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "org.robok.aapt2"
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
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_18)
        }
    }
    
    packaging {
        resources {
            // Exclude all instances of 'plugin.properties'
            excludes += "plugin.properties"

            // Alternatively, keep the first occurrence
            // pickFirsts += "plugin.properties"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "18"
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.13.0-alpha05")
    implementation("androidx.appcompat:appcompat:1.7.0")
    
    implementation("com.google.code.gson:gson:2.11.0")
    
    implementation(project(":feature:feature-util"))
}
