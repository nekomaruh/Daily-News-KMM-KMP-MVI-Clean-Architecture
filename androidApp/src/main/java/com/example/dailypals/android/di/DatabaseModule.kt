package com.example.dailypals.android.di

import com.example.dailypals.cache.DailyPalsDatabase
import com.example.dailypals.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { DatabaseDriverFactory(androidContext()).createDriver() }
    single { DailyPalsDatabase(get()) }
}