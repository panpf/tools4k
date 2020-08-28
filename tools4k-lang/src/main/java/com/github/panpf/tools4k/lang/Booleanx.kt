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

package com.github.panpf.tools4k.lang

/**
 * Execute block if true
 */
inline fun Boolean.yes(block: () -> Unit) {
    if (this) {
        block()
    }
}

/**
 * Execute block if false
 */
inline fun Boolean.no(block: () -> Unit) {
    if (!this) {
        block()
    }
}

/**
 * Execute 'yes' block if true, otherwise execute 'otherwise' block
 * @return If true returning the result of the 'yes' block, otherwise returning the result of the 'otherwise' block
 */
inline fun <R> Boolean.yesElse(block: () -> R): BooleanExt<R> = when {
    this -> WithData(block())
    else -> Otherwise
}

/**
 * Execute 'no' block if false, otherwise execute 'otherwise' block
 * @return If false returning the result of the 'no' block, otherwise returning the result of the 'otherwise' block
 */
inline fun <R> Boolean.noElse(block: () -> R) = when {
    this -> Otherwise
    else -> WithData(block())
}

/**
 * Execute block if true
 * @return If true returning the result of the block, otherwise return null
 */
inline fun <R> Boolean.yesOrNull(block: () -> R): R? = if (this) block() else null

/**
 * Execute block if false
 * @return If false returning the result of the block, otherwise return null
 */
inline fun <R> Boolean.noOrNull(block: () -> R): R? = if (!this) block() else null


sealed class BooleanExt<out R> constructor(val boolean: Boolean)

object Otherwise : BooleanExt<Nothing>(true)
class WithData<out R>(val data: R) : BooleanExt<R>(false)

inline infix fun <R> BooleanExt<R>.otherwise(block: () -> R): R {
    return when (this) {
        is Otherwise -> block()
        is WithData<R> -> this.data
    }
}
