plugins {
    id("java")
    id("io.qameta.allure") version "2.12.0"

}

group = "ru.jeke"
version = "1.0-SNAPSHOT"

allure {
    report {
        version.set("2.24.0")
    }
    adapter{ //отвечает за появление папки build/allure-results
        aspectjWeaver.set(true)
        frameworks {
            junit5 { // название фреймворка
                adapterVersion.set("2.24.0") // версия интеграции фреймворка и аллюр
            }

        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.7.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.5.3")
    testImplementation("org.slf4j:slf4j-simple:2.0.16")
    testImplementation("io.qameta.allure:allure-selenide:2.29.1")

}

tasks.test {
    useJUnitPlatform()
    systemProperties(System.getProperties() as Map<String?, *>)
}