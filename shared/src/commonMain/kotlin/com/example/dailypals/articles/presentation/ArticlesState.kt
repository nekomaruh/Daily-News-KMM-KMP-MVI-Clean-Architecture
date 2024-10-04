package com.example.dailypals.articles.presentation

import com.example.dailypals.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)