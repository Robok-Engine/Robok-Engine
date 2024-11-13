plugins {
  alias(libs.plugins.agp.lib)
  alias(libs.plugins.kotlin)
  alias(libs.plugins.kotlin.serialization)
}

android {
  namespace = "org.robok.easyui"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
    
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
   
  compileOptions {
    sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
    targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
  }
  
  kotlinOptions {
    jvmTarget = libs.versions.android.jvm.get()
  }
}

dependencies {
  implementation(libs.antlr)
  implementation(libs.antlr.runtime)
  implementation(libs.serialization.json)
  implementation(projects.robokEasyUi.antlr4)
}