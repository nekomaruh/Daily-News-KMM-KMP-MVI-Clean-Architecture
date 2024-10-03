package com.example.dailypals.articles.di


import org.koin.dsl.module
import com.example.dailypals.articles.ArticlesService
import com.example.dailypals.articles.ArticlesUseCase
import com.example.dailypals.articles.ArticlesViewModel

val articlesModule = module {
    single { ArticlesService(get()) }
    single { ArticlesUseCase(get()) }
    single { ArticlesViewModel(get()) }
}