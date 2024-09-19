import java.io.ByteArrayOutputStream

plugins {
    alias(libs.plugins.agp.app)
    alias(libs.plugins.kotlin)
    kotlin("plugin.serialization") version "2.0.20"
    id("kotlin-kapt")
    alias(libs.plugins.compose.compiler)
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
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.core.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.splashscreen)
    implementation(libs.preference)
    implementation(libs.datastore.preferences)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.serialization.json)

    implementation(platform(libs.okhttp.bom))
    implementation("com.squareup.okhttp3:okhttp")

    implementation(libs.glide)
    
    implementation(libs.material)

    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(platform(libs.compose.bom))
    implementation(libs.material3.compose)
    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
    implementation(libs.material.motion.compose.core)
    
    implementation(libs.sora.editor)
    
    // projects
    implementation(project(":robok:robok-compiler"))
    implementation(project(":robok:robok-diagnostic"))
    implementation(project(":robok:robok-aapt2"))
    implementation(project(":robok:robok-model3d"))

    implementation(project(":feature:feature-component"))
    implementation(project(":feature:feature-util"))
    implementation(project(":feature:feature-res:strings"))
    implementation(project(":feature:feature-terminal"))
    implementation(project(":feature:feature-template"))
    implementation(project(":feature:feature-treeview"))
    implementation(project(":feature:feature-editor"))

    implementation(project(":feature-compose:feature-component"))
    implementation(project(":feature-compose:feature-settings"))

    implementation(project(":easy-components"))
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
