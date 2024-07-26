plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("maven-publish")
}

group = "robok.diagnostic"

android {
    namespace = "robok.diagnostic"
    compileSdk = 34
    
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        compilerOptions {
            jvmTarget.set("17")
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    val antlrVersion = "4.9.2"

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    
    //Antlr complete and runtime for diagnostics and compilers
    implementation("org.antlr:antlr4:$antlrVersion") // Dependency on ANTLR for code generation
    implementation("org.antlr:antlr4-runtime:$antlrVersion") // ANTLR runtime dependency
    
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.Robok-Inc"
            artifactId = "robok-diagnostic"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}