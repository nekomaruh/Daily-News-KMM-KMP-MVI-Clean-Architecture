package com.example.dailypals.articles.di


import com.example.dailypals.articles.data.ArticlesDataSource
import com.example.dailypals.articles.data.ArticlesRepository
import org.koin.dsl.module
import com.example.dailypals.articles.data.ArticlesService
import com.example.dailypals.articles.domain.ArticlesUseCase
import com.example.dailypals.articles.presentation.ArticlesViewModel

val articlesModule = module {
    single { ArticlesService(get()) }
    single { ArticlesUseCase(get()) }
    single { ArticlesViewModel(get()) }
    single { ArticlesDataSource(get()) }
    single { ArticlesRepository(get(), get()) }
}