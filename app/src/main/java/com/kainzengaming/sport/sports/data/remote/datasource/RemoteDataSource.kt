package com.kainzengaming.sport.sports.data.remote.datasource

import com.kainzengaming.sport.sports.data.remote.model.SportDto
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getSports(): Flow<List<SportDto>>
}