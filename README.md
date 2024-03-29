# Tools4K

![Platform][platform_kotlin_icon]
![kotlin_jvmtarget_icon][kotlin_jvmtarget_icon]
[![Download][release_icon]][release_link]
[![License][license_icon]][license_link]

Extensions to the Kotlin standard library

## Getting Started

This library has been published to `mavenCentral`. Add the following dependencies to your module `build.gradle` file ：
```grovvy
implementation "io.github.panpf.tools4k:tools4k:${LAST_VERSION}"
```

`${LAST_VERSION}`: [![Download][release_icon]][release_link] (no include 'v')

The "io.github.panpf.tools4k:tools4k:${LAST_VERSION}" dependency will add all the modules included in tools4k to your project. If you only need of one of the modules, you can just add it to your project, all supported modules as follows:
```groovy
implementation "io.github.panpf.tools4k:tools4k-coroutines:$LAST_VERSION"
implementation "io.github.panpf.tools4k:tools4k-lang:$LAST_VERSION"
```

Dependencies：
* org.jetbrains.kotlin:kotlin-stdlib-jdk7: 1.5.0
* org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0


## Modules

### tools4j-coroutines
* Coroutinesx: [Coroutinesx.kt] ([Test][CoroutinesxTest.kt])
    * launchOnGlobalDefault, launchOnGlobalMain, launchOnGlobalIO. launchOnGlobalUnconfined
    * asyncOnGlobalDefault, asyncOnGlobalMain, asyncOnGlobalIO. asyncOnGlobalUnconfined
    * syncOnGlobalDefault, syncOnGlobalMain, syncOnGlobalIO. syncOnGlobalUnconfined
    * CoroutineScope.launchOnDefault, CoroutineScope.launchOnMain, CoroutineScope.launchOnIO
    * CoroutineScope.launchOnUnconfined
    * CoroutineScope.asyncOnDefault, CoroutineScope.asyncOnMain, CoroutineScope.asyncOnIO
    * CoroutineScope.asyncOnUnconfined
    * CoroutineScope.syncOnDefault, CoroutineScope.syncOnMain, CoroutineScope.syncOnIO
    * CoroutineScope.syncOnUnconfined
    * withToDefault, withToMain, withToIO, withToUnconfined

### tools4j-lang
* Booleanx: [Booleanx.kt] ([Test][BooleanxTest.kt])
    * yes, no, yesElse, noElse, yesOrNull, noOrNull
* Typex: [Typex.kt] ([Test][TypexTest.kt])
    * asOrThrow, asOrNull

## Change Log

Please view the [CHANGELOG.md] file

## License
    Copyright (C) 2020 panpf <panpfpanpf@outlook.com>

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[platform_kotlin_icon]: https://img.shields.io/badge/Platform-Kotlin-blue.svg
[license_icon]: https://img.shields.io/badge/License-Apache%202-blue.svg
[license_link]: https://www.apache.org/licenses/LICENSE-2.0
[release_icon]: https://img.shields.io/maven-central/v/io.github.panpf.tools4k/tools4k
[release_link]: https://repo1.maven.org/maven2/io/github/panpf/tools4k/
[kotlin_jvmtarget_icon]: https://img.shields.io/badge/KotlinJvmTarget-1.6-red.svg

[Coroutinesx.kt]: tools4k-coroutines/src/main/java/com/github/panpf/tools4k/coroutines/Coroutinesx.kt
[CoroutinesxTest.kt]: tools4k-coroutines/src/test/java/com/github/panpf/tools4k/coroutines/test/CoroutinesxTest.kt

[Booleanx.kt]: tools4k-lang/src/main/java/com/github/panpf/tools4k/lang/Booleanx.kt
[BooleanxTest.kt]: tools4k-lang/src/test/java/com/github/panpf/tools4k/lang/test/BooleanxTest.kt

[Typex.kt]: tools4k-lang/src/main/java/com/github/panpf/tools4k/lang/Typex.kt
[TypexTest.kt]: tools4k-lang/src/test/java/com/github/panpf/tools4k/lang/test/TypexTest.kt

[CHANGELOG.md]: CHANGELOG.md
