package com.rainbowt0506.newsapp.presentation.bookmark

import com.rainbowt0506.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)