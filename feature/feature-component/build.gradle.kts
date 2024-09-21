plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "org.gampiot.robok.feature.component"
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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}

dependencies {
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.13.0-alpha06")
    implementation("androidx.appcompat:appcompat:1.7.0")
    
    val editorGroupId = "io.github.Rosemoe.sora-editor"
    implementation(platform("$editorGroupId:bom:0.23.4"))
    implementation("$editorGroupId:editor")
    implementation("$editorGroupId:editor-lsp")
    implementation("$editorGroupId:language-java")
    implementation("$editorGroupId:language-textmate")
    
    val antlrVersion = "4.13.2"
    implementation("org.antlr:antlr4:$antlrVersion") 
    implementation("org.antlr:antlr4-runtime:$antlrVersion")
    
    implementation(project(":feature:feature-res:strings"))
    
    implementation(project(":robok:robok-compiler"))
    implementation(project(":robok:robok-diagnostic"))
}
