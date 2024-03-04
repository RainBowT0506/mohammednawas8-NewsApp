package com.rainbowt0506.newsapp.domain.usecases.app_entry

import com.rainbowt0506.newsapp.domain.manger.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManger: LocalUserManger) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }
}