plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "org.gampiot.robok.feature.component"
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
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    
    val editorGroupId = "io.github.Rosemoe.sora-editor"
    implementation(platform("$editorGroupId:bom:0.23.4"))
    implementation("$editorGroupId:editor")
    implementation("$editorGroupId:editor-lsp")
    implementation("$editorGroupId:language-java")
    implementation("$editorGroupId:language-textmate")
    
    val antlrVersion = "4.9.2"
    implementation("org.antlr:antlr4:$antlrVersion") 
    implementation("org.antlr:antlr4-runtime:$antlrVersion")
    
    val trindadeUtilVersion = "3.1.1"
    implementation("com.github.aquilesTrindade.trindade-util:components:$trindadeUtilVersion")
    
    implementation(project(":feature:feature-res:strings"))
    
    implementation(project(":robok:robok-compiler"))
    implementation(project(":robok:robok-diagnostic"))
}