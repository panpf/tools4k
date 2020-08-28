/*
 * Copyright (C) 2020 panpf <panpfpanpf@outlook.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.panpf.tools4k.coroutines

import kotlinx.coroutines.*


fun launchOnGlobalDefault(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> Unit): Job {
    return GlobalScope.launch(context = Dispatchers.Default, start = start, block = block)
}

fun launchOnGlobalMain(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> Unit): Job {
    return GlobalScope.launch(context = Dispatchers.Main, start = start, block = block)
}

fun launchOnGlobalIO(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> Unit): Job {
    return GlobalScope.launch(context = Dispatchers.IO, start = start, block = block)
}

fun launchOnGlobalUnconfined(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> Unit): Job {
    return GlobalScope.launch(context = Dispatchers.Unconfined, start = start, block = block)
}


fun <T> asyncOnGlobalDefault(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): Deferred<T> {
    return GlobalScope.async(context = Dispatchers.Default, start = start, block = block)
}

fun <T> asyncOnGlobalMain(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): Deferred<T> {
    return GlobalScope.async(context = Dispatchers.Main, start = start, block = block)
}

fun <T> asyncOnGlobalIO(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): Deferred<T> {
    return GlobalScope.async(context = Dispatchers.IO, start = start, block = block)
}

fun <T> asyncOnGlobalUnconfined(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): Deferred<T> {
    return GlobalScope.async(context = Dispatchers.Unconfined, start = start, block = block)
}


suspend fun <T> syncOnGlobalDefault(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): T {
    return GlobalScope.async(context = Dispatchers.Default, start = start, block = block).await()
}

suspend fun <T> syncOnGlobalMain(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): T {
    return GlobalScope.async(context = Dispatchers.Main, start = start, block = block).await()
}

suspend fun <T> syncOnGlobalIO(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): T {
    return GlobalScope.async(context = Dispatchers.IO, start = start, block = block).await()
}

suspend fun <T> syncOnGlobalUnconfined(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): T {
    return GlobalScope.async(context = Dispatchers.Unconfined, start = start, block = block).await()
}


fun CoroutineScope.launchOnDefault(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(context = Dispatchers.Default, start = start, block = block)
}

fun CoroutineScope.launchOnMain(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(context = Dispatchers.Main, start = start, block = block)
}

fun CoroutineScope.launchOnIO(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(context = Dispatchers.IO, start = start, block = block)
}

fun CoroutineScope.launchOnUnconfined(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> Unit): Job {
    return this.launch(context = Dispatchers.Unconfined, start = start, block = block)
}


fun <T> CoroutineScope.asyncOnDefault(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): Deferred<T> {
    return this.async(context = Dispatchers.Default, start = start, block = block)
}

fun <T> CoroutineScope.asyncOnMain(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): Deferred<T> {
    return this.async(context = Dispatchers.Main, start = start, block = block)
}

fun <T> CoroutineScope.asyncOnIO(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): Deferred<T> {
    return this.async(context = Dispatchers.IO, start = start, block = block)
}

fun <T> CoroutineScope.asyncOnUnconfined(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): Deferred<T> {
    return this.async(context = Dispatchers.Unconfined, start = start, block = block)
}


suspend fun <T> CoroutineScope.syncOnDefault(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): T {
    return this.async(context = Dispatchers.Default, start = start, block = block).await()
}

suspend fun <T> CoroutineScope.syncOnMain(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): T {
    return this.async(context = Dispatchers.Main, start = start, block = block).await()
}

suspend fun <T> CoroutineScope.syncOnIO(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): T {
    return this.async(context = Dispatchers.IO, start = start, block = block).await()
}

suspend fun <T> CoroutineScope.syncOnUnconfined(start: CoroutineStart = CoroutineStart.DEFAULT, block: suspend CoroutineScope.() -> T): T {
    return this.async(context = Dispatchers.Unconfined, start = start, block = block).await()
}


suspend fun <T> withToDefault(block: suspend CoroutineScope.() -> T): T {
    return withContext(context = Dispatchers.Default, block = block)
}

suspend fun <T> withToMain(block: suspend CoroutineScope.() -> T): T {
    return withContext(context = Dispatchers.Main, block = block)
}

suspend fun <T> withToIO(block: suspend CoroutineScope.() -> T): T {
    return withContext(context = Dispatchers.IO, block = block)
}

suspend fun <T> withToUnconfined(block: suspend CoroutineScope.() -> T): T {
    return withContext(context = Dispatchers.Unconfined, block = block)
}
