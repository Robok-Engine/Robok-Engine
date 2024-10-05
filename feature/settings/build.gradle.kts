plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    id("maven-publish")
}

android {
    namespace = "org.robok.engine.feature.settings"
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
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.datastore.preferences)
    implementation(libs.material)
    implementation(libs.lifecycle.runtime.ktx)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.github.robok-engine"
            artifactId = "feature-settings"
            version  = "0.0.1"
            
            from(components.findByName("release"))
        }
    }
}