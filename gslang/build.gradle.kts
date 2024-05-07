plugins {
    id("com.android.library")
    id("maven-publish")
}

val lib_version = "v1.0.0"

android {
    namespace = "gslang"
    compileSdk = 34

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName("debug") {
            defaultConfig.minSdk = 21
            
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
            
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

publishing {
    publications {
        create<MavenPublication>("release") {
            from(components["release"])
            groupId = "com.github.aquilestrindade"
            artifactId = "GSLang"
            version = lib_version
        }
    }
}