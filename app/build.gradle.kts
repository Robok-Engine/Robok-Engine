import java.io.ByteArrayOutputStream

plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "org.gampiot.robok"
    compileSdk = 35

    defaultConfig {
        applicationId = "org.gampiot.robok"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = getVersionName()

        vectorDrawables {
            useSupportLibrary = true
        }
        
        // git fields
        buildConfigField("String", "GIT_COMMIT_HASH", "\"${getGitHash()}\"")
        buildConfigField("String", "GIT_BRANCH", "\"${getGitBranch()}\"")
        buildConfigField("String", "GIT_COMMIT_AUTHOR", "\"${getGitCommitAuthor()}\"")
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

    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
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
    val appcompatVersion = "1.7.0-alpha03"
    val kotlinVersion = "2.0.10"
    val kotlinCoroutinesVersion = "1.9.0-RC"
    val glideVersion = "4.16.0"

    // androidx
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.fragment:fragment-ktx:1.8.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4") 
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

    // google
    implementation("com.google.android.material:material:$materialVersion")

    // jetbrains
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
    
    // squareup
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    
    // Robok
    implementation(project(":robok:robok-compiler"))
    implementation(project(":robok:robok-diagnostic"))
    implementation(project(":robok:robok-aapt2"))
    implementation(project(":robok-sdk")) // This implementation will be removed in the future, it is just here to compile.
    
    // Features
    implementation(project(":feature:feature-component"))
    implementation(project(":feature:feature-util"))
    implementation(project(":feature:feature-res:strings"))
    implementation(project(":feature:feature-setting"))
    implementation(project(":feature:feature-terminal"))
    
    val trindadeUtilVersion = "3.1.1"
    implementation("com.github.aquilesTrindade.trindade-util:filepicker:$trindadeUtilVersion")
    implementation("com.github.aquilesTrindade.trindade-util:components:$trindadeUtilVersion")

    implementation("com.github.bumptech.glide:glide:$glideVersion")
    
    // Add desugaring dependency
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")
    
    implementation("io.github.Rosemoe.sora-editor:editor:0.23.4")
}

// git fuctions

fun getGitHash(): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine("git", "rev-parse", "HEAD")
        standardOutput = stdout
    }
    return stdout.toString().trim()
}

fun getShortGitHash(): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine("git", "rev-parse", "--short", "HEAD")
        standardOutput = stdout
    }
    return stdout.toString().trim()
}

fun getGitBranch(): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine("git", "rev-parse", "--abbrev-ref", "HEAD")
        standardOutput = stdout
    }
    return stdout.toString().trim()
}

fun getGitCommitAuthor(): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine("git", "log", "-1", "--pretty=format:%an")
        standardOutput = stdout
    }
    return stdout.toString().trim()
}

fun getVersionName(): String {
    val baseVersion = "1.0.0"
    val shortHash = getShortGitHash()
    return "$baseVersion-$shortHash"
}
