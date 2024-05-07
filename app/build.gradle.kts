plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.trindade.gamide"
    compileSdk = 34
    
    def gitCommitHash = "git rev-parse HEAD".execute().text.trim()

    def getCommitHash = { ->
        def stdout = new ByteArrayOutputStream()
        exec {
            commandLine "git", "rev-parse", "--short", "HEAD"
            standardOutput = stdout
        }
        return stdout.toString().trim()
    }
    
    defaultConfig {
        applicationId = "com.trindade.gamide"
        minSdk = 26
        targetSdk = 34
        versionCode = 0
        versionName "v1.0.0-SNAPSHOT-" + getCommitHash()

        buildConfigField("String", "GIT_HASH", "\"${gitCommitHash}\"")
        
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