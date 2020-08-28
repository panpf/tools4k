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

import com.github.panpf.tools4k.lang.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class BooleanxTest {

    @Test
    fun testYes() {
        var result = "1"

        true.yes { result = "2" }
        assertEquals("2", result)

        result = "3"
        false.yes { result = "4" }
        assertEquals("3", result)
    }

    @Test
    fun testNo() {
        var result = "1"

        true.no { result = "2" }
        assertEquals("1", result)

        result = "3"
        false.no { result = "4" }
        assertEquals("4", result)
    }

    @Test
    fun testYesOr() {
        assertEquals("yes", true.yesElse { "yes" }.otherwise { "no" })
        assertEquals("no", false.yesElse { "yes" }.otherwise { "no" })
    }

    @Test
    fun testNoOr() {
        assertEquals("no", true.noElse { "yes" }.otherwise { "no" })
        assertEquals("yes", false.noElse { "yes" }.otherwise { "no" })
    }

    @Test
    fun testYesOrNull() {
        assertEquals("pass", true.yesOrNull { "pass" })
        assertNull(false.yesOrNull { "pass" })
    }

    @Test
    fun testNoOrNull() {
        assertNull(true.noOrNull { "pass" })
        assertEquals("pass", false.noOrNull { "pass" })
    }
}