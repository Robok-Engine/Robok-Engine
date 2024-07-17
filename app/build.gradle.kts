plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = "dev.trindadeaquiles.robokide"
    compileSdk = 34
    
    defaultConfig {
        applicationId = "dev.trindadeaquiles.robokide"
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
        isCoreLibraryDesugaringEnabled = true
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

    val robokLanguageVersion = "1.0.0"
    val materialVersion = "1.13.0-alpha04"
    val appcompatVersion = "1.7.0-alpha03"
    val kotlinVersion = "2.0.0"
    val kotlinCoroutinesVersion = "1.9.0-RC"
    val okhttp3Version = "4.12.0"
    val activityVersion = "1.9.0"
    val glideVersion = "4.16.0"
    val trindadeutilVersion = "3.0.1"
    val antlrVersion = "4.9.2"
    
    val editorGroupId = "io.github.Rosemoe.sora-editor"
        
    // androidx
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.fragment:fragment-ktx:1.8.1")
    
    // google
    implementation("com.google.android.material:material:$materialVersion")
    implementation("com.google.code.gson:gson:2.11.0")
    
    // jetbrains
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    
    // squareup
    implementation("com.squareup.okhttp3:okhttp:$okhttp3Version")    
    
    // dagger
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")
    
    // filepicker
    implementation("com.github.Ruan625Br:FilePickerSphere:1.0.0")
    

    // Sora editor
    implementation(platform("$editorGroupId:bom:0.23.4"))
    implementation("$editorGroupId:editor")
    implementation("$editorGroupId:editor-lsp")
    implementation("$editorGroupId:language-java")
    implementation("$editorGroupId:language-treesitter")
    implementation("$editorGroupId:language-textmate")
    
    // implementation("com.github.Robok-Foundation:Robok-Language:$robokLanguageVersion")
    implementation(project(":language"))
    
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    kapt("com.github.bumptech.glide:compiler:$glideVersion")
    
    // aquiles trindade libs
    implementation("com.github.aquilesTrindade.trindade-util:github:$trindadeutilVersion")
    implementation("com.github.aquilesTrindade.trindade-util:preferencesv2:$trindadeutilVersion")
    
    // Add desugaring dependency
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
    
    //Antlr complete and runtime for diagnostics and compilers
    implementation("org.antlr:antlr4:$antlrVersion") // Dependency on ANTLR for code generation
    implementation("org.antlr:antlr4-runtime:$antlrVersion") // ANTLR runtime dependency
    
    
    //Progress bouncy dots
    implementation("com.agrawalsuneet.androidlibs:dotsloader:v1.4.2")
    
}
