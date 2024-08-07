package com.kainzengaming.sport.sports.data.remote

import com.kainzengaming.sport.sports.data.model.SportDto

interface RemoteDataSource {
    suspend fun getSports(): List<SportDto>
}