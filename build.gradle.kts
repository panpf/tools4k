buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("KOTLIN_VERSION")}")
        classpath("com.github.panpf.bintray-publish:bintray-publish:${property("BINTRAY_PUBLISH")}")
    }
}

allprojects {
    repositories {
        jcenter()
        mavenCentral()
    }
}