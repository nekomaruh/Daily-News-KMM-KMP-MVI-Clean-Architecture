package com.example.dailypals

expect class Platform {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val screenDensity: Int

    fun logSystemInfo()
}

