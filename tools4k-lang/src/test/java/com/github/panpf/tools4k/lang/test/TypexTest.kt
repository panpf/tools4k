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

package com.github.panpf.tools4k.lang.test

import com.github.panpf.tools4k.lang.asOrThrow
import com.github.panpf.tools4k.lang.asOrNull
import org.junit.Assert
import org.junit.Test

class TypexTest {

    @Test
    fun testAsTo() {
        try {
            Assert.assertEquals(3, 2.asOrThrow<Int>().plus(1))
        } catch (e: Exception) {
            Assert.fail()
        }

        try {
            Assert.assertEquals("21", "2".asOrThrow<String>().plus("1"))
        } catch (e: Exception) {
            Assert.fail()
        }

        try {
            Assert.assertEquals(3, "2".asOrThrow<Int>().plus(1))
            Assert.fail()
        } catch (e: Exception) {
        }

        try {
            Assert.assertEquals("21", 2.asOrThrow<String>().plus("1"))
            Assert.fail()
        } catch (e: Exception) {
        }
    }

    @Test
    fun testAsToOrNull() {
        Assert.assertNotNull(2.asOrNull<Int>())
        Assert.assertNotNull("2".asOrNull<String>())
        Assert.assertNull("2".asOrNull<Int>())
        Assert.assertNull(2.asOrNull<String>())
        Assert.assertNull(null.asOrNull<Int>())
        Assert.assertNull(null.asOrNull<String>())
    }
}