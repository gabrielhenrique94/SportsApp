package com.kainzengaming.sport.sports.domain.repository

import com.kainzengaming.sport.sports.domain.model.Sport

interface SportsRepository {
    suspend fun getSports(): List<Sport>
}