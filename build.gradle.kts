plugins {
    id("java")
}

group = "ru.tbank.edu"
version = "1.0-SNAPSHOT"

val slf4jVersion: String by extra("2.0.9")
val jacksonVersion: String by extra("2.16.1")
val lombokVersion: String by extra("1.18.30")

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-simple:$slf4jVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jacksonVersion")
    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")
}
