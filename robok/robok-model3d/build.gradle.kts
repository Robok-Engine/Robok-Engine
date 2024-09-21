plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "org.robok.model3d"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "18"
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.13.0-alpha06")
    implementation("androidx.appcompat:appcompat:1.7.0")
    
    implementation("com.badlogicgames.gdx:gdx:1.12.1")
    implementation("com.badlogicgames.gdx:gdx-backend-android:1.12.1")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-armeabi-v7a")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-x86_64")

    implementation("com.google.code.gson:gson:2.11.0")
    
    implementation(project(":feature:feature-util"))
}
