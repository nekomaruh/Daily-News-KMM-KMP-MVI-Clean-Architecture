package com.example.dailypals.articles

import com.example.dailypals.utils.getDaysAgo

class ArticlesUseCase(private val repository: ArticlesRepository) {
    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articles = repository.getAllArticles(forceFetch)
        return _mapArticleRawToArticle(articles)
    }

    fun _mapArticleRawToArticle(articlesRaw: List<ArticleRaw>): List<Article> {
        return articlesRaw.map {
            Article(
                title = it.title,
                description = it.description ?: "No description available",
                imageUrl = it.imageUrl ?: "https://via.placeholder.com/150",
                date = it.date.getDaysAgo()
            )
        }
    }
}

