package com.kainzengaming.sport.sports.data.remote.di

import com.google.gson.GsonBuilder
import com.kainzengaming.sport.gson.GsonStringTypeAdapter
import com.kainzengaming.sport.sports.data.remote.datasource.RemoteDataSource
import com.kainzengaming.sport.sports.data.remote.datasource.RemoteDataSourceImpl
import com.kainzengaming.sport.sports.data.remote.service.SportsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(
            GsonBuilder()
                .setLenient()
                .registerTypeAdapter(String::class.java, GsonStringTypeAdapter())
                .create()
        ))
        .baseUrl("https://618d3aa7fe09aa001744060a.mockapi.io/api/")
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): SportsService =
        retrofit.create(SportsService::class.java)


    @Provides
    fun provideRemoteDataSource(service: SportsService): RemoteDataSource =
        RemoteDataSourceImpl(service)
}