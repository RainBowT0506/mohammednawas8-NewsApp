package com.rainbowt0506.newsapp.di

import android.app.Application
import com.rainbowt0506.newsapp.data.manger.LocalUserMangerImpl
import com.rainbowt0506.newsapp.domain.manger.LocalUserManger
import com.rainbowt0506.newsapp.domain.usecases.AppEntryUseCases
import com.rainbowt0506.newsapp.domain.usecases.ReadAppEntry
import com.rainbowt0506.newsapp.domain.usecases.SaveAppEntry
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