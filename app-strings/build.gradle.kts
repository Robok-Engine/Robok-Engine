import java.io.ByteArrayOutputStream

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
    
    resValue("string", "app_version", "1.0.0")
    resValue("string", "GIT_COMMIT_HASH", getGitHash())
    resValue("string", "GIT_COMMIT_SHORT_HASH", getShortGitHash())
    resValue("string", "GIT_COMMIT_AUTHOR", getGitCommitAuthor())
    resValue("string", "GIT_COMMIT_BRANCH", getGitBranch())
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
  implementation(libs.google.material)
  implementation(libs.androidx.appcompat)
}

fun execAndGetOutput(vararg command: String): String {
  val stdout = ByteArrayOutputStream()
  exec {
    commandLine(*command)
    standardOutput = stdout
  }
  return stdout.toString().trim()
}

fun getGitHash() = execAndGetOutput("git", "rev-parse", "HEAD")

fun getShortGitHash() = execAndGetOutput("git", "rev-parse", "--short", "HEAD")

fun getGitBranch() = execAndGetOutput("git", "rev-parse", "--abbrev-ref", "HEAD")

fun getGitCommitAuthor(): String {
  val author = execAndGetOutput("git", "log", "-1", "--pretty=format:%an")
  return author.replace(Regex("[^\\p{L}\\p{N}\\s]"), "") // Remove special characters
}
