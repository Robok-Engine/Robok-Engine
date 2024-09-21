plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "org.robok.diagnostic"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
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
   
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
        targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
    }

    kotlinOptions {
        jvmTarget = libs.versions.android.jvm.get()
    }
}

dependencies {
    val antlrVersion = "4.13.2"
    
    implementation("androidx.appcompat:appcompat:1.7.0")

    //Antlr complete and runtime for diagnostics and compilers
    implementation("org.antlr:antlr4:$antlrVersion") // Dependency on ANTLR for code generation
    implementation("org.antlr:antlr4-runtime:$antlrVersion") // ANTLR runtime dependency
}
