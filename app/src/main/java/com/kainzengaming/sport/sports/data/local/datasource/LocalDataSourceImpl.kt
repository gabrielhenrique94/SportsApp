package com.kainzengaming.sport.sports.data.local.datasource

import com.kainzengaming.sport.sports.data.local.database.SportsDatabase
import com.kainzengaming.sport.sports.data.local.mapper.toFavoriteEvent
import com.kainzengaming.sport.sports.data.local.model.FavoriteEvent
import com.kainzengaming.sport.sports.domain.model.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val sportsDatabase: SportsDatabase) :
    LocalDataSource {
    override suspend fun saveFavoriteEvent(event: Event) =
        sportsDatabase.eventsDao().insert(event.toFavoriteEvent())

    override fun getFavoriteEvents(): Flow<List<FavoriteEvent>> = flow {
        emit(sportsDatabase.eventsDao().getAll())
    }

    override suspend fun removeFavoriteEvent(favoriteEvents: Event) =
        sportsDatabase.eventsDao().delete(favoriteEvents.toFavoriteEvent())
}