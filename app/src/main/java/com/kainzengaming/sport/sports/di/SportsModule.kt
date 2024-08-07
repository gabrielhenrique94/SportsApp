package com.kainzengaming.sport.sports.di

import com.kainzengaming.sport.sports.data.SportsRepositoryImpl
import com.kainzengaming.sport.sports.domain.repository.SportsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class SportsModule {
    @Binds
    abstract fun bindSportsRepository(sportsRepositoryImpl: SportsRepositoryImpl): SportsRepository

}