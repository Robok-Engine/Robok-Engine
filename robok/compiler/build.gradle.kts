
plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("maven-publish")
}

group = "robok.compiler"

android {
    namespace = "robok.compiler"
    compileSdk = 34
    
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
   
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    implementation(project(":robok:util"))
    implementation(project(":robok:method"))
    implementation(project(":robok:lang"))
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.Robok-Inc"
            artifactId = "robok-compiler"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
