package com.rainbowt0506.newsapp.domain.usecases.news

import com.rainbowt0506.newsapp.data.local.NewsDao
import com.rainbowt0506.newsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}