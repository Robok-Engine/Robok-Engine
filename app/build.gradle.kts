import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.io.ByteArrayOutputStream

plugins {
    alias(libs.plugins.agp.app)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.about.libraries.plugin)
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

val app_version = "2.0.0"

android {
    namespace = "org.robok.engine"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        applicationId = "org.robok.engine"
        versionCode = 2
        versionName = app_version
        
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    
    packaging {
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
        sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
        targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
        isCoreLibraryDesugaringEnabled = true
    }
    
    kotlinOptions {
        jvmTarget = libs.versions.android.jvm.get()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "@${getShortGitHash()}"
        }
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
        compose = true
    }

    /* disabled because not work in old versions 
    androidResources {
        generateLocaleConfig = true
    }
    */

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
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.core.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.splashscreen)
    implementation(libs.datastore.preferences)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.serialization.json)
    
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)

    implementation(libs.glide)
    
    implementation(libs.material)

    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(platform(libs.compose.bom))
    implementation(libs.material3.compose)
    implementation(libs.activity.compose)
    implementation(libs.navigation.compose)
    implementation(libs.material.motion.compose.core)
    implementation(libs.material.icons.extended)
    
    implementation(libs.libgdx)
    implementation(libs.libgdx.backend.android)
    
    implementation(libs.sora.editor)
    
    implementation(libs.termux.terminal.view)
    implementation(libs.termux.terminal.emulator)
    
    implementation(libs.coil.compose)

    implementation(libs.gson)
    
    implementation(libs.about.libraries.core)
    implementation(libs.about.libraries.compose)
    implementation(libs.about.libraries.compose.m3)
    
    implementation(libs.insetter)
    
    // projects
    implementation(project(":robok:antlr4:java"))
    implementation(project(":robok:aapt2"))
    
    implementation(project(":app-strings"))
    
    implementation(project(":feature:treeview"))
    implementation(project(":feature:editor"))
    implementation(project(":feature:modeling"))
    implementation(project(":feature:xmlviewer"))
    
    implementation(project(":core:templates"))
    implementation(project(":core:components"))
    implementation(project(":core:utils"))
    
    implementation(project(":feature:settings"))
}

fun execAndGetOutput(vararg command: String): String {
    val stdout = ByteArrayOutputStream()
    exec {
        commandLine(*command)
        standardOutput = stdout
    }
    return stdout.toString().trim()
}

fun getShortGitHash() = execAndGetOutput("git", "rev-parse", "--short", "HEAD")
