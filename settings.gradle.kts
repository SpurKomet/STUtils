rootProject.name = "STUtils"
include("STUtilsKt")
include("STUtilsJava")

pluginManagement {
    repositories {
        gradlePluginPortal()
        // PaperMC Repo
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://libraries.minecraft.net")
    }
}
