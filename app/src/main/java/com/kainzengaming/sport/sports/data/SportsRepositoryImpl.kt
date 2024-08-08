package com.kainzengaming.sport.sports.data

import com.kainzengaming.sport.sports.data.local.datasource.LocalDataSource
import com.kainzengaming.sport.sports.data.local.model.FavoriteEvent
import com.kainzengaming.sport.sports.data.remote.mapper.toDomain
import com.kainzengaming.sport.sports.data.remote.datasource.RemoteDataSource
import com.kainzengaming.sport.sports.data.remote.model.SportDto
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.domain.repository.SportsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SportsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) :
    SportsRepository {

    override fun getSports(): Flow<List<Sport>> =
        remoteDataSource.getSports()
            .combine(localDataSource.getFavoriteEvents()) { sports, favorites ->
                val sportsWithFavorites = mutableListOf<Sport>()
                sports
                    .filter {
                        it.name != null
                    }
                    .forEach { sport ->
                        sportsWithFavorites.add(sport.toDomain(favorites))
                    }
                sportsWithFavorites
            }

    override suspend fun favoriteEvent(event: Event) {
        localDataSource.saveFavoriteEvent(event)
    }

    override suspend fun removeFavoriteEvent(event: Event) {
        localDataSource.removeFavoriteEvent(event)
    }

}