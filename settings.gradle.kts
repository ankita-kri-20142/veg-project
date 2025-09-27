pluginManagement {
    repositories {
        google() // Required for Android + Firebase
        mavenCentral() // Kotlin + AndroidX
        gradlePluginPortal() // Gradle Plugins
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev") // JetBrains Compose (optional)
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MinuteBazarApp"
include(":app")
