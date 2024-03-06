package com.rainbowt0506.newsapp.presentation.search

import androidx.paging.PagingData
import com.rainbowt0506.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)