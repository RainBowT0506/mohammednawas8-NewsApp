package com.rainbowt0506.newsapp.domain.repository

import androidx.paging.PagingData
import com.rainbowt0506.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}