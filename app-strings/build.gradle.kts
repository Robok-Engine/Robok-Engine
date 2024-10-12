plugins {
    alias(libs.plugins.agp.lib)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "org.robok.engine.strings"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    buildTypes {
        getByName("release") {
            resValue("string", "app_name", "Robok")
            resValue("string", "app_version", app_version)
            resValue("string", "GIT_COMMIT_HASH", getGitHash())
            resValue("string", "GIT_COMMIT_AUTHOR", getGitCommitAuthor())
            resValue("string", "GIT_COMMIT_BRANCH", getGitBranch())
        }
        getByName("debug") {
            resValue("string", "app_name", "Robok Debug")
            resValue("string", "app_version", app_version)
            resValue("string", "GIT_COMMIT_HASH", getGitHash())
            resValue("string", "GIT_COMMIT_AUTHOR", getGitCommitAuthor())
            resValue("string", "GIT_COMMIT_BRANCH", getGitBranch())
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
    implementation(libs.material)
    implementation(libs.appcompat)
}
