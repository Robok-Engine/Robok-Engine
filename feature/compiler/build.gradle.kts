plugins {
  alias(libs.plugins.agp.lib)
  alias(libs.plugins.kotlin)
}

android {
  namespace = "org.robok.engine.feature.compiler"
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

  packaging {
    resources {
      excludes += "plugin.properties"
    }
  }
}

dependencies {
  implementation(fileTree("libs") { include("*.jar") })

  implementation(libs.google.material)
  implementation(libs.androidx.appcompat)

  implementation(libs.google.gson)

  implementation(projects.feature.apksigner)
  implementation(projects.core.utils)

  implementation(libs.android.r8)
}