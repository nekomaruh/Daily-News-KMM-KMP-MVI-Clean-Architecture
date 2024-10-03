package com.example.dailypals.articles.di


import com.example.dailypals.articles.ArticlesDataSource
import com.example.dailypals.articles.ArticlesRepository
import org.koin.dsl.module
import com.example.dailypals.articles.ArticlesService
import com.example.dailypals.articles.ArticlesUseCase
import com.example.dailypals.articles.ArticlesViewModel

val articlesModule = module {
    single { ArticlesService(get()) }
    single { ArticlesUseCase(get()) }
    single { ArticlesViewModel(get()) }
    single { ArticlesDataSource(get()) }
    single { ArticlesRepository(get(), get()) }
}