package com.kainzengaming.sport.sports.data.remote.datasource

import com.kainzengaming.sport.sports.data.remote.model.SportDto
import com.kainzengaming.sport.sports.data.remote.service.SportsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val service: SportsService) :
    RemoteDataSource {
    override fun getSports(): Flow<List<SportDto>> = flow {
        emit(service.getSports().toList())
    }
}