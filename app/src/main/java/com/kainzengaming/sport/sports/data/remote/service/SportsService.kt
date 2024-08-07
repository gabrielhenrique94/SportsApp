package com.kainzengaming.sport.sports.data.remote.service

import com.kainzengaming.sport.sports.data.remote.model.SportDto
import retrofit2.http.GET

interface SportsService {

    @GET("sports")
    suspend fun getSports(): Array<SportDto>
}