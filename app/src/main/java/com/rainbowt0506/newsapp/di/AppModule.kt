package com.rainbowt0506.newsapp.di

import android.app.Application
import com.rainbowt0506.newsapp.data.manger.LocalUserMangerImpl
import com.rainbowt0506.newsapp.data.remote.NewsRepositoryImpl
import com.rainbowt0506.newsapp.data.remote.dto.NewsApi
import com.rainbowt0506.newsapp.domain.manger.LocalUserManger
import com.rainbowt0506.newsapp.domain.repository.NewsRepository
import com.rainbowt0506.newsapp.domain.usecases.app_entry.AppEntryUseCases
import com.rainbowt0506.newsapp.domain.usecases.app_entry.ReadAppEntry
import com.rainbowt0506.newsapp.domain.usecases.app_entry.SaveAppEntry
import com.rainbowt0506.newsapp.domain.usecases.news.GetNews
import com.rainbowt0506.newsapp.domain.usecases.news.NewsUseCase
import com.rainbowt0506.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCase {
        return NewsUseCase(
            getNews = GetNews(newsRepository)
        )
    }
}