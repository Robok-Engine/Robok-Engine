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
include(":feature:xmlviewer")
include(":feature:apksigner")
include(":feature:compiler")
include(":feature:graphics:modeling")

include(":core:components")
include(":core:utils")
include(":core:antlr4:java")
include(":core:settings")
include(":core:database")

include(":robok-easy-ui:antlr4")
include(":robok-easy-ui:gui")