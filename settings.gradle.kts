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

include(":robok:old-compiler")
include(":robok:antlr4:java")
include(":robok:lang")
include(":robok:util")
include(":robok:aapt2")

include(":app-strings")

include(":feature:treeview")
include(":feature:editor")
include(":feature:modeling")

include(":feature:settings")

include(":core-compose:components")

include(":core:components")
include(":core:utils")
include(":core:templates")

include(":easy-components")