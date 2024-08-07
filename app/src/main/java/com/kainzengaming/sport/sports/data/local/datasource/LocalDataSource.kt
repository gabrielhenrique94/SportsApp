package com.kainzengaming.sport.sports.data.local.datasource

import com.kainzengaming.sport.sports.data.local.model.FavoriteEvent
import com.kainzengaming.sport.sports.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun saveFavoriteEvent(event: Event)
    fun getFavoriteEvents(): Flow<List<FavoriteEvent>>
    suspend fun removeFavoriteEvent(favoriteEvents: Event)
}