buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("KOTLIN_VERSION")}")
        classpath("com.novoda:bintray-release:${property("BINTRAY_RELEASE")}")
    }
}

allprojects {
    repositories {
        jcenter()
        mavenCentral()
    }
}