package com.example.dailypals.di

import com.example.dailypals.articles.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.component.inject

fun initKoin() {
    val modules = sharedModules

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}

