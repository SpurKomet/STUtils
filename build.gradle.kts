plugins {
    kotlin("jvm") version "1.6.21"
    id("io.papermc.paperweight.userdev") version "1.3.5"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("xyz.jpenilla.run-paper") version "1.0.6"
    java
}
val mcVersion = "1.18.2"

group = "de.spurowski"
version = "$mcVersion"

repositories {
    mavenCentral()
    maven("https://repo.md-5.net/content/groups/public/")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    // PaperMC Dependency
    paperDevBundle("$mcVersion-R0.1-SNAPSHOT")

    // KSpigot dependency
    compileOnly("net.axay:kspigot:1.18.2")
    compileOnly("org.apache.httpcomponents:httpclient:4.5.13")
    compileOnly("org.apache.httpcomponents:httpmime:4.5.13")
    compileOnly("com.comphenix.protocol:ProtocolLib:4.7.0")
    compileOnly("LibsDisguises:LibsDisguises:10.0.28")
    compileOnly("io.papermc.paper:paper-api:${mcVersion}-R0.1-SNAPSHOT")
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "18"
        }
    }
    build {
        dependsOn(reobfJar)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_18
}

bukkit {
    name = "STUtils"
    apiVersion = "1.18"
    authors = listOf(
        "SpurKomet",
        "tbodyowski",
    )
    depend = listOf("LibsDisguises", "ProtocolLib")
    main = "$group.youtuberideen.YoutuberIdeen"
    version = getVersion().toString()
    libraries = listOf(
        "net.axay:kspigot:1.18.2",
        "org.apache.httpcomponents:httpclient:4.5.13",
        "org.apache.httpcomponents:httpmime:4.5.13"
    )
}