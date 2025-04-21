import org.gradle.api.tasks.JavaExec

plugins {
    id("java")
    id("application")
}

group = "battleship"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://packages.jetbrains.team/maven/p/hyperskill-hs-test/maven") }
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation("com.github.hyperskill:hs-test:release-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("battleship.Main")
}

tasks.named<JavaExec>("run") {
  standardInput = System.`in` // allows user to interact with the game.
}
