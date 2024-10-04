package com.example.dailypals.articles.data

import com.example.dailypals.cache.DailyPalsDatabase

class ArticlesDataSource(
    private val database: DailyPalsDatabase
) {

    fun getAllArticles(): List<ArticleRaw> {
        return database.dailyPalsDatabaseQueries.selectArticles(::mapToArticleRaw).executeAsList()
    }

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyPalsDatabaseQueries.transaction {
            articles.forEach {
                database.dailyPalsDatabaseQueries.insertArticle(
                    title = it.title,
                    description = it.description,
                    date = it.date,
                    imageUrl = it.imageUrl
                )
            }
        }
    }

    fun removeAllArticles() {
        database.dailyPalsDatabaseQueries.removeAllArticles()
    }


    private fun mapToArticleRaw(
        title: String,
        description: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw = ArticleRaw(
        title = title,
        description = description,
        date = date,
        imageUrl = imageUrl
    )

}