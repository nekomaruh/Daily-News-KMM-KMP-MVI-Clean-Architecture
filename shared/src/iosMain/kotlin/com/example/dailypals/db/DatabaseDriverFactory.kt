package com.example.dailypals.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.dailypals.cache.DailyPalsDatabase

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(DailyPalsDatabase.Schema, "DailyPalsDatabase.db")
    }
}