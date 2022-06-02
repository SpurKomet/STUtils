plugins {
    java
}
val mcVersion = "1.18.2"

group = "de.tbodyowski"
version = "$mcVersion"

repositories {
    mavenCentral()
    maven("https://repo.md-5.net/content/groups/public/")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    // PaperMC Dependency
    compileOnly("io.papermc.paper:paper-api:${mcVersion}-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(18)
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(18))
}

