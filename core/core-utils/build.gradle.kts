plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "org.gampiot.robok.core.utils"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    buildFeatures {
        viewBinding = true
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
    implementation(libs.material)
    implementation(libs.appcompat)
    implementation(libs.core.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.datastore.preferences)
    
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    
    implementation(platform(libs.compose.bom))
    implementation(libs.material3.compose)
    implementation(libs.material.compose)
    implementation(libs.ui.compose)
    
    implementation(project(":easy-components"))
    
    implementation(project(":app-strings"))
    implementation(project(":feature-compose:feature-settings"))
}