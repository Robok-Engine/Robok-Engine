plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("plugin.serialization") version "2.0.20"
}

android {
    namespace = "org.gampiot.robok.feature.editor"
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
    
    buildFeatures {
        viewBinding = true
    }
   
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.13.0-alpha05")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.5")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0-RC.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.2")
    
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    
    implementation("io.insert-koin:koin-android:3.5.6")
    
    val editorGroupId = "io.github.Rosemoe.sora-editor"
    implementation(platform("$editorGroupId:bom:0.23.4"))
    implementation("$editorGroupId:editor")
    implementation("$editorGroupId:editor-lsp")
    implementation("$editorGroupId:language-java")
    implementation("$editorGroupId:language-textmate")
    
    val antlrVersion = "4.13.2"
    implementation("org.antlr:antlr4:$antlrVersion") 
    implementation("org.antlr:antlr4-runtime:$antlrVersion")
    
    implementation(project(":feature:feature-res:strings"))
    implementation(project(":feature-compose:feature-settings"))
    
    implementation(project(":robok:robok-compiler"))
    implementation(project(":robok:robok-diagnostic"))
}
