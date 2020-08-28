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
 * Convert to the type specified by the generic
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <R> Any.asOrThrow(): R {
    @Suppress("UNCHECKED_CAST")
    return this as R
}

/**
 * Convert to the type specified by the generic, if this is null or cannot be converted return null
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <reified R> Any?.asOrNull(): R? {
    return if (this != null && this is R) this else null
}