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
include(":robok:robok-diagnostic")
include(":robok:robok-lang")
include(":robok:robok-util")
include(":robok:robok-aapt2")
include(":robok:robok-model3d")

include(":feature:feature-component")
include(":feature:feature-res:strings")
include(":feature:feature-util")
include(":feature:feature-template")
include(":feature:feature-terminal")
include(":feature:feature-treeview")
include(":feature:feature-editor")

include(":feature-compose:feature-component")
include(":feature-compose:feature-settings")

include(":easy-components")
include(":easy-filepicker")
