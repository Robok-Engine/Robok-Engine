import java.io.ByteArrayOutputStream

plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("plugin.serialization") version "2.0.20"
    id("com.mikepenz.aboutlibraries.plugin")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "org.gampiot.robok"
    compileSdk = 35

    defaultConfig {
        applicationId = "org.gampiot.robok"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "0.0.1"
        
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
            resValue("string", "GIT_COMMIT_HASH", getGitHash())
            resValue("string", "GIT_COMMIT_AUTHOR", getGitCommitAuthor())
            resValue("string", "GIT_COMMIT_BRANCH", getGitBranch())
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            versionNameSuffix = getShortGitHash()
            resValue("string", "app_name", "Robok Debug")
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
    val materialVersion = "1.13.0-alpha05"
    val appcompatVersion = "1.7.0"
    val kotlinCoroutinesVersion = "1.9.0-RC.2"
    val glideVersion = "4.16.0"
    val aboutLibrariesVersion = "11.2.3"
    val koinVersion = "3.5.6"

    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.fragment:fragment-ktx:1.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
    implementation("androidx.core:core-splashscreen:1.2.0-alpha02")
    implementation("androidx.preference:preference:1.2.1")
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.2")
    
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    
    implementation("com.google.android.material:material:$materialVersion")

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
    
    val editorGroupId = "io.github.Rosemoe.sora-editor"
    implementation(platform("$editorGroupId:bom:0.23.4"))
    implementation("$editorGroupId:editor")
    
    implementation("com.mikepenz:aboutlibraries:11.2.3")
    implementation("com.github.bumptech.glide:glide:$glideVersion")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.2")
    
    implementation("com.mikepenz:aboutlibraries-core:$aboutLibrariesVersion")
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation("io.insert-koin:koin-androidx-compose:$koinVersion")
    
    implementation(platform("androidx.compose:compose-bom:2024.08.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("io.github.fornewid:material-motion-compose-core:2.0.1")
    implementation("com.mikepenz:aboutlibraries-compose:$aboutLibrariesVersion")
    implementation("com.mikepenz:aboutlibraries-compose-m3:$aboutLibrariesVersion")
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
