package com.rainbowt0506.newsapp.di

import android.app.Application
import com.rainbowt0506.newsapp.data.manger.LocalUserMangerImpl
import com.rainbowt0506.newsapp.domain.manger.LocalUserManger
import com.rainbowt0506.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.rainbowt0506.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.rainbowt0506.newsapp.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providerLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun providerAppEntryUseCases(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}