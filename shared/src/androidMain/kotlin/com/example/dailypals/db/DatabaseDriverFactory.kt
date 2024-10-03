package com.example.dailypals.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.dailypals.cache.DailyPalsDatabase

actual class DatabaseDriverFactory(
    private val context: Context
) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = DailyPalsDatabase.Schema,
            context = context,
            name = "DailyPalsDatabase.db"
        )
    }
}