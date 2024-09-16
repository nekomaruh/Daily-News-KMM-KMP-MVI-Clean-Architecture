package com.example.dailypals

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel {
    val scope: CoroutineScope
}
