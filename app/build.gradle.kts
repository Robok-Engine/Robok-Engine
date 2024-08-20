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

        // git fields
        buildConfigField("String", "GIT_COMMIT_HASH", "\"${getGitHash()}\"")
        buildConfigField("String", "GIT_BRANCH", "\"${getGitBranch()}\"")
        buildConfigField("String", "GIT_COMMIT_AUTHOR", "\"${getGitCommitAuthor()}\"")
        
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
    val appcompatVersion = "1.7.0-alpha03"

    // androidx
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.fragment:fragment-ktx:1.8.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")
    implementation("androidx.core:core-splashscreen:1.2.0-alpha01")
    implementation("androidx.preference:preference:1.2.1")
    
    // google
    implementation("com.google.android.material:material:$materialVersion")

    // Robok
    implementation(project(":robok:robok-compiler"))
    implementation(project(":robok:robok-diagnostic"))
    implementation(project(":robok:robok-aapt2"))

    // Features
    implementation(project(":feature:feature-component"))
    implementation(project(":feature:feature-util"))
    implementation(project(":feature:feature-res:strings"))
    implementation(project(":feature:feature-setting"))
    implementation(project(":feature:feature-terminal"))
    implementation(project(":feature:feature-template"))
    implementation(project(":feature:feature-treeview"))
    
    val trindadeUtilVersion = "d049be6cc0"
    implementation("com.github.aquilesTrindade.trindade-util:filepicker:$trindadeUtilVersion")
    implementation("com.github.aquilesTrindade.trindade-util:components:$trindadeUtilVersion")

    // Add desugaring dependency
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

    implementation("io.github.Rosemoe.sora-editor:editor:0.23.4")
}

// git functions

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

fun getVersionName(): String {
    val baseVersion = "1.0.0"
    val shortHash = getShortGitHash()
    return "$baseVersion-$shortHash"
}
