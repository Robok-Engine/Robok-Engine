@file:Suppress("UnstableApiUsage")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}

dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
    maven(url = "https://jitpack.io")
  }
}

rootProject.name = "Robok-Engine"

include(":app")

include(":app-strings")

include(":feature:treeview")
include(":feature:editor")
include(":feature:compiler")

include(":core:ui:components")
include(":core:utils")
include(":core:settings")
include(":core:database")
