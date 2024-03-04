package com.rainbowt0506.newsapp.domain.usecases.app_entry

import com.rainbowt0506.newsapp.domain.manger.LocalUserManger

class SaveAppEntry(private val localUserManger: LocalUserManger) {

    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }
}