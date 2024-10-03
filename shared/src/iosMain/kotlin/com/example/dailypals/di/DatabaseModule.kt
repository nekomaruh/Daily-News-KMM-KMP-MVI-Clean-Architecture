package com.example.dailypals.di

import com.example.dailypals.cache.DailyPalsDatabase
import com.example.dailypals.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseDriverFactory().createDriver() }
    single { DailyPalsDatabase(get()) }

}