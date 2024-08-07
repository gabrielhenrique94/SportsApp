package com.kainzengaming.sport.sports.data.local.di

import android.content.Context
import androidx.room.Room
import com.kainzengaming.sport.sports.data.local.database.SportsDatabase
import com.kainzengaming.sport.sports.data.local.datasource.LocalDataSource
import com.kainzengaming.sport.sports.data.local.datasource.LocalDataSourceImpl
import com.kainzengaming.sport.sports.data.remote.datasource.RemoteDataSource
import com.kainzengaming.sport.sports.data.remote.datasource.RemoteDataSourceImpl
import com.kainzengaming.sport.sports.data.remote.service.SportsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideSportsDatabase(@ApplicationContext context: Context): SportsDatabase {
        return Room.databaseBuilder(
            context,
            SportsDatabase::class.java,
            SportsDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideLocalDataSource(database: SportsDatabase): LocalDataSource =
        LocalDataSourceImpl(database)
}