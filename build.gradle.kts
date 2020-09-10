buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("KOTLIN_VERSION")}")
        classpath("com.github.panpf.bintraypublish:bintraypublish:${property("BINTRAY_PUBLISH")}")
    }
}

allprojects {
    repositories {
        jcenter()
        mavenCentral()
    }
}