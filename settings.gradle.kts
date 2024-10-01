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

include(":robok:robok-compiler")
include(":robok:robok-antlr")
include(":robok:robok-lang")
include(":robok:robok-util")
include(":robok:robok-aapt2")

include(":app-strings")

include(":feature:feature-treeview")
include(":feature:feature-editor")
include(":feature:feature-modeling")

include(":feature-compose:feature-settings")

include(":core-compose:core-components")

include(":core:core-components")
include(":core:core-utils")
include(":core:core-templates")

include(":easy-components")