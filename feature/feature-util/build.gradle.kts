plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "org.gampiot.robok.feature.util"
    compileSdk = 35
    
    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.13.0-alpha06")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.fragment:fragment-ktx:1.8.3")
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    implementation("androidx.preference:preference:1.2.1")
    
   val koinVersion = "4.0.0"
    implementation("io.insert-koin:koin-android:$koinVersion")
    
    // Easy - UI
    implementation(project(":easy-components"))
    
    implementation(project(":feature:feature-res:strings"))
    implementation(project(":feature:feature-component"))
    implementation(project(":feature-compose:feature-settings"))
}