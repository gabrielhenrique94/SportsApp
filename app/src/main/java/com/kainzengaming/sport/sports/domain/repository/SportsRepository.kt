package com.kainzengaming.sport.sports.domain.repository

import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface SportsRepository {
    fun getSports(): Flow<List<Sport>>
    suspend fun favoriteEvent(event: Event)
    suspend fun removeFavoriteEvent(event: Event)
}