plugins {
  alias(libs.plugins.agp.lib)
  alias(libs.plugins.kotlin)
}

android {
  namespace = "org.robok.engine.feature.filetree"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
    
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
  implementation(libs.androidx.appcompat)
  implementation(libs.google.material)
  implementation(libs.androidx.recyclerview)
}