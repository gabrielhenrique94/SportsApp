package com.kainzengaming.sport.sports.data.remote

import com.kainzengaming.sport.sports.data.model.SportDto
import com.kainzengaming.sport.sports.data.service.SportsService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: SportsService) : RemoteDataSource {
    override suspend fun getSports(): List<SportDto> = service.getSports().toList()
}