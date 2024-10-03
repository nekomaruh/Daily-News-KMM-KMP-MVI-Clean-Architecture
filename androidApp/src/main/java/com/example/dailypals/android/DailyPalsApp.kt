package com.example.dailypals.android

import android.app.Application
import com.example.dailypals.android.di.viewmodelsModule
import com.example.dailypals.di.sharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPalsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedModules + viewmodelsModule
        startKoin {
            androidContext(this@DailyPalsApp)
            modules(modules)
        }
    }

}