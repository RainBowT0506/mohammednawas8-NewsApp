package com.rainbowt0506.newsapp.domain.usecases

import com.rainbowt0506.newsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManger: LocalUserManger) {

    suspend operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }
}