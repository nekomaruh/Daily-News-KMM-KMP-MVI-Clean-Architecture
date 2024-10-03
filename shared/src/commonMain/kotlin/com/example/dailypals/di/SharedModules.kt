package com.example.dailypals.di

import com.example.dailypals.articles.di.articlesModule

val sharedModules = listOf(
    articlesModule,
    networkModule
)