import com.novoda.gradle.release.PublishExtension
import java.util.*

plugins{
    id("kotlin")
}

group = "com.github.panpf.tools4k"
version = property("VERSION").toString()

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.6"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.6"
    }
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${property("KOTLIN_VERSION")}")
    api(project(":tools4k-coroutines"))
    api(project(":tools4k-lang"))

    testImplementation("junit:junit:${property("JUNIT_VERSION")}")
}

/*
 * publish
 */
project.file("local.properties").takeIf { it.exists() }?.let { file -> file.inputStream().use { input -> Properties().apply { load(input) } } }?.takeIf { !it.isEmpty }?.let { moduleLocalProperties ->
    apply(plugin = "com.novoda.bintray-release")

    configure<PublishExtension> {
        groupId = "com.github.panpf.tools4k"
        artifactId = "tools4k"
        publishVersion = property("VERSION").toString()
        desc = "Kotlin, Tools"
        website = "https://github.com/panpf/tools4k"
        userOrg = moduleLocalProperties.getProperty("bintray.userOrg")
        bintrayUser = moduleLocalProperties.getProperty("bintray.user")
        bintrayKey = moduleLocalProperties.getProperty("bintray.apikey")
    }
}