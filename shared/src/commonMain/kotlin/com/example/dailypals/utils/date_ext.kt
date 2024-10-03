package com.example.dailypals.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

fun String.getDaysAgo(): String {
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    val days = today.daysUntil(
        Instant.parse(this).toLocalDateTime(TimeZone.currentSystemDefault()).date
    )
    return when {
        abs(days) > 1 -> "$days day ago"
        abs(days) == 1 -> "Yesterday"
        else -> "Today"
    }
}