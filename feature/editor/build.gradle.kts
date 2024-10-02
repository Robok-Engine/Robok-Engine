plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
    id("maven-publish")
    kotlin("plugin.serialization") version "2.0.20"
}

android {
    namespace = "org.gampiot.robok.feature.editor"
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

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.13.0-alpha06")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.datastore:datastore-preferences:1.1.1")
    
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.12.0"))
    implementation("com.squareup.okhttp3:okhttp")
    
    implementation("io.insert-koin:koin-android:4.0.0")
    
    val editorGroupId = "io.github.Rosemoe.sora-editor"
    implementation(platform("$editorGroupId:bom:0.23.4"))
    implementation("$editorGroupId:editor")
    implementation("$editorGroupId:editor-lsp")
    implementation("$editorGroupId:language-java")
    implementation("$editorGroupId:language-textmate")
    
    val antlrVersion = "4.13.2"
    implementation("org.antlr:antlr4:$antlrVersion") 
    implementation("org.antlr:antlr4-runtime:$antlrVersion")
    
    implementation(project(":app-strings"))
    implementation(project(":feature-compose:settings"))
    implementation(project(":core:utils"))
    
    implementation(project(":robok:compiler"))
    implementation(project(":robok:antlr"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.github.robok-engine"
            artifactId = "feature-editor"
            version  = "0.0.1"
            
            from(components.findByName("release"))
        }
    }
}
