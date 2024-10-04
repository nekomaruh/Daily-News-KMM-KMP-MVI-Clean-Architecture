package com.example.dailypals.android.di

import com.example.dailypals.articles.presentation.ArticlesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelsModule = module {
    viewModel { ArticlesViewModel(get()) }
}