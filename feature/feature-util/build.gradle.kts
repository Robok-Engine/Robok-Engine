plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "org.gampiot.robok.feature.util"
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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    implementation(libs.material)
    implementation(libs.material)
    implementation(libs.core.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.datastore.preferences")
    implementation(libs.koin-android)
    
    implementation(project(":easy-components"))
    
    implementation(project(":feature:feature-res:strings"))
    implementation(project(":feature:feature-component"))
    implementation(project(":feature-compose:feature-settings"))
}