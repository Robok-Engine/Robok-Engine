plugins {
    id("com.android.library")
    id("maven-publish")
}

group = "gslang"

android {
    namespace = "gslang"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 26
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
        //noinspection DataBindingWithoutKapt
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.aquilestrindade"
            artifactId = "gslang"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
