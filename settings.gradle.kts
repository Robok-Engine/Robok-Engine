@file:Suppress("UnstableApiUsage")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
  repositories {
    includeBuild("build-logic")
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
include(":feature:modeling")
include(":feature:xmlviewer")
include(":feature:settings")
include(":feature:apksigner")
include(":feature:compiler")

include(":core:components")
include(":core:utils")
include(":core:antlr4:java")

include(":robok-easy-ui:antlr4")
include(":robok-easy-ui:gui")