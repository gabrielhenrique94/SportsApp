package com.kainzengaming.sport.sports.data.service

import com.kainzengaming.sport.sports.data.model.SportDto
import retrofit2.http.GET

interface SportsService {

    @GET("sports")
    suspend fun getSports(): Array<SportDto>
}