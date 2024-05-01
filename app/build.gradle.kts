plugins {
    id("com.android.application")
}

android {
    compileSdk = 34
    namespace = "com.trindade.gamide"
	
    defaultConfig {
        applicationId = "com.trindade.gamide"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation ("androidx.appcompat:appcompat:1.6.1")
	implementation ("com.google.android.material:material:1.9.0")
	implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
}
