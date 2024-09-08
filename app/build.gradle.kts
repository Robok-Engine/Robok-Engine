plugins {
    alias(libs.plugins.agp.app)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.aboutlibraries)
    id("kotlin-kapt")
    id("kotlinx-serialization")
    kotlin("plugin.serialization") version "2.0.20"
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
            versionNameSuffix = getShortGitHash()
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
    implementation(libs.coreKtx)
    implementation(libs.fragmentKtx)
    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.lifecycleViewModelKtx)
    implementation(libs.lifecycleLiveDataKtx)
    implementation(libs.coreSplashscreen)
    implementation(libs.preference)
    implementation(libs.datastorePreferences)
    
    implementation(libs.kotlinCoroutinesCore)
    implementation(libs.kotlinCoroutinesAndroid)
    implementation(libs.kotlinxSerializationJson)
    
    implementation(libs.okhttp)
    
    implementation(libs.material)

    implementation(project(":robok:robok-compiler"))
    implementation(project(":robok:robok-diagnostic"))
    implementation(project(":robok:robok-aapt2"))

    implementation(project(":feature:feature-component"))
    implementation(project(":feature:feature-util"))
    implementation(project(":feature:feature-res:strings"))
    implementation(project(":feature:feature-terminal"))
    implementation(project(":feature:feature-template"))
    implementation(project(":feature:feature-treeview"))
    implementation(project(":feature:feature-editor"))
    
    implementation(project(":feature-compose:feature-component"))
    implementation(project(":feature-compose:feature-settings"))
    
    implementation(project(":easy-ui:components"))
    implementation(project(":easy-ui:filepicker"))
    
    implementation(libs.soraEditor)
    
    implementation(libs.aboutlibraries)
    implementation(libs.glide)

    coreLibraryDesugaring(libs.desugar)
    
    implementation(libs.aboutlibrariesCore)
    implementation(libs.koin)
    implementation(libs.koinCompose)
    
    implementation(platform(libs.compose))
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation(libs.activityCompose)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.5")
    implementation(libs.navigationCompose)
    implementation(libs.materialMotionCompose)
    implementation(libs.aboutlibrariesCompose)
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
