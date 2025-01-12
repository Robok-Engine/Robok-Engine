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

android {
  namespace = "org.robok.engine"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()
    applicationId = "org.robok.engine"
    versionCode = 100
    versionName = "1.0.0"
    
    vectorDrawables.useSupportLibrary = true
  }
  
  packaging {
    jniLibs.useLegacyPackaging = true
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
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
    getByName("debug") {
      versionNameSuffix = "@${getShortGitHash()}"
    }
  }
  
  buildFeatures {
    buildConfig = true
    viewBinding = true
    compose = true
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
  compilerOptions {
    jvmTarget = JvmTarget.JVM_17
  }
}

dependencies {
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.lifecycle.runtime.ktx)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.fragment.ktx)
  implementation(libs.androidx.splashscreen)
  implementation(libs.androidx.datastore.preferences)

  implementation(libs.ktx.coroutines.core)
  implementation(libs.ktx.coroutines.android)
  implementation(libs.ktx.serialization.json)
    
  implementation(libs.koin.android)
  implementation(libs.koin.androidx.compose)

  implementation(libs.glide)
    
  implementation(libs.google.material)

  coreLibraryDesugaring(libs.desugar.jdk.libs)

  implementation(platform(libs.compose.bom))
  implementation(libs.compose.material3)
  implementation(libs.compose.activity)
  implementation(libs.compose.navigation)
  implementation(libs.compose.material.motion.core)
  implementation(libs.compose.material.icons)
    
  implementation(libs.libgdx)
  implementation(libs.libgdx.backend.android)
    
  implementation(libs.sora.editor)
  implementation(libs.sora.editor.language.textmate)
    
  implementation(libs.termux.terminal.view)
  implementation(libs.termux.terminal.emulator)
    
  implementation(libs.coil.compose)

  implementation(libs.google.gson)
    
  implementation(libs.ktor.client.android)
  implementation(libs.ktor.client.content.negotiation)
  implementation(libs.ktor.serialization.kotlix.json)
  implementation(libs.slf4j)
    
  implementation(libs.about.libraries.core)
  implementation(libs.about.libraries.compose)
  implementation(libs.about.libraries.compose.m3)
  
  implementation(libs.insetter)
  
  // projects
  
  implementation(projects.appStrings)
  
  implementation(projects.feature.treeview)
  implementation(projects.feature.editor)
  implementation(projects.feature.modeling)
  implementation(projects.feature.xmlviewer)
  implementation(projects.feature.compiler)
  
  implementation(projects.core.settings)
  implementation(projects.core.database)
  implementation(projects.core.components)
  implementation(projects.core.utils)
  implementation(projects.core.antlr4.java)
  
  implementation(projects.robokEasyUi.gui)
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
