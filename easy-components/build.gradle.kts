plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    id("maven-publish")
}

android {
    namespace = "dev.trindadedev.easyui.components"
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.github.robok-engine"
            artifactId = "easy-components"
            version  = "0.0.1"
            
            from(components.findByName("release"))
        }
    }
}
