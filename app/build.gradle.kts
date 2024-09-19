import java.io.ByteArrayOutputStream

plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("plugin.serialization") version "2.0.20"
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.compose")
}

val app_version = "0.0.1"

android {
    namespace = "org.gampiot.robok"
    compileSdk = 35

    defaultConfig {
        applicationId = "org.gampiot.robok"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = app_version
        
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    
    packagingOptions {
        jniLibs {
            useLegacyPackaging = true
        }
    }
    
    sourceSets {
        getByName("main") {
            jniLibs.srcDirs("src/main/jniLibs")
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
            resValue("string", "app_name", "Robok")
            resValue("string", "app_version", app_version)
            resValue("string", "GIT_COMMIT_HASH", getGitHash())
            resValue("string", "GIT_COMMIT_AUTHOR", getGitCommitAuthor())
            resValue("string", "GIT_COMMIT_BRANCH", getGitBranch())
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "@${getShortGitHash()}"
            resValue("string", "app_name", "Robok Debug")
            resValue("string", "app_version", app_version)
            resValue("string", "GIT_COMMIT_HASH", getGitHash())
            resValue("string", "GIT_COMMIT_AUTHOR", getGitCommitAuthor())
            resValue("string", "GIT_COMMIT_BRANCH", getGitBranch())
        }
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    androidResources {
        generateLocaleConfig = true
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
    implementation(libs.appcompat)
    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.coreKtx)
    implementation(libs.fragmentKtx)
    implementation(libs.splashscreen)
    implementation(libs.preference)
    implementation(libs.datastorePreferences)
    
    implementation(libs.coroutinesCore)
    implementation(libs.coroutinesAndroid)
    implementation(libs.serializationJson)
    
    implementation(platform(libs.okhttpBom))
    implementation("com.squareup.okhttp3:okhttp")
    
    implementation(libs.glide)
    
    coreLibraryDesugaring(libs.desugarJdkLibs)
    
    implementation(platform(libs.composeBom))
    implementation(libs.activityCompose)
    implementation(libs.navigationCompose)
    implementation(libs.materialMotionComposeCore)
}

fun execAndGetOutput(vararg command: String): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine(*command)
        standardOutput = stdout
    }
    return stdout.toString().trim()
}

fun getGitHash() = execAndGetOutput("git", "rev-parse", "HEAD")

fun getShortGitHash() = execAndGetOutput("git", "rev-parse", "--short", "HEAD")

fun getGitBranch() = execAndGetOutput("git", "rev-parse", "--abbrev-ref", "HEAD")

fun getGitCommitAuthor() = execAndGetOutput("git", "log", "-1", "--pretty=format:%an")
