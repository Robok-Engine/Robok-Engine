plugins {
    id("com.android.library")
}

val app_version = "v1.0.0"

android {
    namespace = "gslang"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
        targetSdk = 34
        consumerProguardFiles("consumer-rules.pro")
        versionName = app_version
    }

    buildFeatures {
        buildConfig = false
    }

    buildTypes {
        getByName("debug") {
            defaultConfig.minSdk = 26
            buildConfigField("String", "GIT_HASH", "${app_version}-Debug")
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
            buildConfigField("String", "GIT_HASH", "${app_version}-Release")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
}