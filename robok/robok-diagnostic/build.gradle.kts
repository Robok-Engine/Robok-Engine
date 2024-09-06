plugins {
    id("com.android.library")
    id("kotlin-android")
    id("maven-publish")
}

android {
    namespace = "org.robok.diagnostic"
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
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "18"
}

dependencies {
    val antlrVersion = "4.13.2"
    
    implementation("androidx.appcompat:appcompat:1.7.0")

    //Antlr complete and runtime for diagnostics and compilers
    implementation("org.antlr:antlr4:$antlrVersion") // Dependency on ANTLR for code generation
    implementation("org.antlr:antlr4-runtime:$antlrVersion") // ANTLR runtime dependency
    
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.robok-inc"
            artifactId = "robok-diagnostic"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}