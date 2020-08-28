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

package com.github.panpf.tools4k.coroutines.test

import com.github.panpf.tools4k.coroutines.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Test

class CoroutinesxTest {

    @Test
    fun testLaunchOnGlobal() {
        Dispatchers.setMain(TestCoroutineDispatcher())

        val currentThreadHashCode = Thread.currentThread().hashCode()
        var defaultThreadHashCode: Int? = null
        launchOnGlobalDefault {
            defaultThreadHashCode = Thread.currentThread().hashCode()
        }
        var unconfinedThreadHashCode: Int? = null
        launchOnGlobalUnconfined {
            unconfinedThreadHashCode = Thread.currentThread().hashCode()
        }
        var mainThreadHashCode: Int? = null
        launchOnGlobalMain {
            mainThreadHashCode = Thread.currentThread().hashCode()
        }
        var ioThreadHashCode: Int? = null
        launchOnGlobalIO {
            ioThreadHashCode = Thread.currentThread().hashCode()
        }
        Thread.sleep(1000)
        Assert.assertNotEquals(currentThreadHashCode, defaultThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, unconfinedThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, mainThreadHashCode)
        Assert.assertNotEquals(currentThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(defaultThreadHashCode, mainThreadHashCode)
        Assert.assertEquals(defaultThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(mainThreadHashCode, ioThreadHashCode)
    }

    @Test
    fun testAsyncOnGlobal() {
        Dispatchers.setMain(TestCoroutineDispatcher())

        val currentThreadHashCode = Thread.currentThread().hashCode()
        var defaultThreadHashCode: Int? = null
        asyncOnGlobalDefault {
            defaultThreadHashCode = Thread.currentThread().hashCode()
        }
        var unconfinedThreadHashCode: Int? = null
        asyncOnGlobalUnconfined {
            unconfinedThreadHashCode = Thread.currentThread().hashCode()
        }
        var mainThreadHashCode: Int? = null
        asyncOnGlobalMain {
            mainThreadHashCode = Thread.currentThread().hashCode()
        }
        var ioThreadHashCode: Int? = null
        asyncOnGlobalIO {
            ioThreadHashCode = Thread.currentThread().hashCode()
        }
        Thread.sleep(1000)
        Assert.assertNotEquals(currentThreadHashCode, defaultThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, unconfinedThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, mainThreadHashCode)
        Assert.assertNotEquals(currentThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(defaultThreadHashCode, mainThreadHashCode)
        Assert.assertEquals(defaultThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(mainThreadHashCode, ioThreadHashCode)
    }

    @Test
    fun testSyncOnGlobal() {
        Dispatchers.setMain(TestCoroutineDispatcher())
        var currentThreadHashCode: Int? = null
        var defaultThreadHashCode: Int? = null
        var unconfinedThreadHashCode: Int? = null
        var mainThreadHashCode: Int? = null
        var ioThreadHashCode: Int? = null
        runBlocking {
            currentThreadHashCode = Thread.currentThread().hashCode()
            defaultThreadHashCode = syncOnGlobalDefault {
                Thread.currentThread().hashCode()
            }
            unconfinedThreadHashCode = syncOnGlobalUnconfined {
                Thread.currentThread().hashCode()
            }
            mainThreadHashCode = syncOnGlobalMain {
                Thread.currentThread().hashCode()
            }
            ioThreadHashCode = syncOnGlobalIO {
                Thread.currentThread().hashCode()
            }
        }

        Thread.sleep(1000)
        Assert.assertNotEquals(currentThreadHashCode, defaultThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, unconfinedThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, mainThreadHashCode)
        Assert.assertNotEquals(currentThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(defaultThreadHashCode, mainThreadHashCode)
        Assert.assertEquals(defaultThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(mainThreadHashCode, ioThreadHashCode)
    }

    @Test
    fun testScopeLaunchOnGlobal() {
        val testScope = TestCoroutineScope()

        Dispatchers.setMain(TestCoroutineDispatcher())

        val currentThreadHashCode = Thread.currentThread().hashCode()
        var defaultThreadHashCode: Int? = null
        testScope.launchOnDefault {
            defaultThreadHashCode = Thread.currentThread().hashCode()
        }
        var unconfinedThreadHashCode: Int? = null
        testScope.launchOnUnconfined {
            unconfinedThreadHashCode = Thread.currentThread().hashCode()
        }
        var mainThreadHashCode: Int? = null
        testScope.launchOnMain {
            mainThreadHashCode = Thread.currentThread().hashCode()
        }
        var ioThreadHashCode: Int? = null
        testScope.launchOnIO {
            ioThreadHashCode = Thread.currentThread().hashCode()
        }
        Thread.sleep(1000)
        Assert.assertNotEquals(currentThreadHashCode, defaultThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, unconfinedThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, mainThreadHashCode)
        Assert.assertNotEquals(currentThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(defaultThreadHashCode, mainThreadHashCode)
        Assert.assertEquals(defaultThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(mainThreadHashCode, ioThreadHashCode)
    }

    @Test
    fun testScopeAsyncOnGlobal() {
        val testScope = TestCoroutineScope()
        Dispatchers.setMain(TestCoroutineDispatcher())

        val currentThreadHashCode = Thread.currentThread().hashCode()
        var defaultThreadHashCode: Int? = null
        testScope.asyncOnDefault {
            defaultThreadHashCode = Thread.currentThread().hashCode()
        }
        var unconfinedThreadHashCode: Int? = null
        testScope.asyncOnUnconfined {
            unconfinedThreadHashCode = Thread.currentThread().hashCode()
        }
        var mainThreadHashCode: Int? = null
        testScope.asyncOnMain {
            mainThreadHashCode = Thread.currentThread().hashCode()
        }
        var ioThreadHashCode: Int? = null
        testScope.asyncOnIO {
            ioThreadHashCode = Thread.currentThread().hashCode()
        }
        Thread.sleep(1000)
        Assert.assertNotEquals(currentThreadHashCode, defaultThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, unconfinedThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, mainThreadHashCode)
        Assert.assertNotEquals(currentThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(defaultThreadHashCode, mainThreadHashCode)
        Assert.assertEquals(defaultThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(mainThreadHashCode, ioThreadHashCode)
    }

    @Test
    fun testScopeSyncOnGlobal() {
        val testScope = TestCoroutineScope()
        Dispatchers.setMain(TestCoroutineDispatcher())
        var currentThreadHashCode: Int? = null
        var defaultThreadHashCode: Int? = null
        var unconfinedThreadHashCode: Int? = null
        var mainThreadHashCode: Int? = null
        var ioThreadHashCode: Int? = null
        runBlocking {
            currentThreadHashCode = Thread.currentThread().hashCode()
            defaultThreadHashCode = testScope.syncOnDefault {
                Thread.currentThread().hashCode()
            }
            unconfinedThreadHashCode = testScope.syncOnUnconfined {
                Thread.currentThread().hashCode()
            }
            mainThreadHashCode = testScope.syncOnMain {
                Thread.currentThread().hashCode()
            }
            ioThreadHashCode = testScope.syncOnIO {
                Thread.currentThread().hashCode()
            }
        }

        Thread.sleep(1000)
        Assert.assertNotEquals(currentThreadHashCode, defaultThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, unconfinedThreadHashCode)
        Assert.assertEquals(currentThreadHashCode, mainThreadHashCode)
        Assert.assertNotEquals(currentThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(defaultThreadHashCode, mainThreadHashCode)
        Assert.assertEquals(defaultThreadHashCode, ioThreadHashCode)
        Assert.assertNotEquals(mainThreadHashCode, ioThreadHashCode)
    }

//    @Test
//    fun testWith(){
//        Dispatchers.setMain(TestCoroutineDispatcher())
//        var currentThreadHashCode: Int? = null
//        var defaultThreadHashCode: Int? = null
//        var unconfinedThreadHashCode: Int? = null
//        var mainThreadHashCode: Int? = null
//        var ioThreadHashCode: Int? = null
//        GlobalScope.launch {
//            currentThreadHashCode = Thread.currentThread().hashCode()
//
//            defaultThreadHashCode = withToDefault {
//                Thread.currentThread().hashCode()
//            }
//            unconfinedThreadHashCode = withToUnconfined {
//                Thread.currentThread().hashCode()
//            }
//            mainThreadHashCode = withToMain {
//                Thread.currentThread().hashCode()
//            }
//            ioThreadHashCode = withToIO {
//                Thread.currentThread().hashCode()
//            }
//        }
//
//        Thread.sleep(3000)
//        Assert.assertEquals(currentThreadHashCode, defaultThreadHashCode)
//        Assert.assertEquals(currentThreadHashCode, unconfinedThreadHashCode)
//        Assert.assertEquals(currentThreadHashCode, mainThreadHashCode)
//        Assert.assertNotEquals(currentThreadHashCode, ioThreadHashCode)
//        Assert.assertEquals(defaultThreadHashCode, mainThreadHashCode)
//        Assert.assertNotEquals(defaultThreadHashCode, ioThreadHashCode)
//        Assert.assertNotEquals(mainThreadHashCode, ioThreadHashCode)
//    }
}