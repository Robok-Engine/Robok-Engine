plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
}

android {
    namespace = "dev.trindade.robokide"
    compileSdk = 34
    
    defaultConfig {
        applicationId = "dev.trindade.robokide"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        
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
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
    
    signingConfigs {
        getByName("debug") {
            storeFile = file(layout.buildDirectory.dir("../testkey.keystore"))
            storePassword = "testkey"
            keyAlias = "testkey"
            keyPassword = "testkey"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

dependencies {

    val robok_version = "2.0.0-fix01"
    val kotlin_version = "2.0.0"
    val kotlin_coroutines_version = "1.9.0-RC"
    val compose_version = "2024.05.00"
    val okhttp3_version = "4.9.3"
    val activity_version = "1.9.0"
    
    // androidx
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.fragment:fragment-ktx:1.3.6")
    
    
    // google
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.google.code.gson:gson:2.8.8")
    
    // jetbrains
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlin_coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlin_coroutines_version")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    
    // squareup
    implementation("com.squareup.okhttp3:okhttp:$okhttp3_version")
    
    // compose
    implementation(platform("androidx.compose:compose-bom:$compose_version"))
    implementation("androidx.compose.material3:material3")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.activity:activity-compose:$activity_version")
    implementation("androidx.activity:activity:$activity_version")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    
    implementation("com.github.Robok-Foundation:Robok-Language:$robok_version")
}
