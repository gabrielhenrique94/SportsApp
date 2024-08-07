package com.kainzengaming.sport.sports.data

import com.kainzengaming.sport.sports.data.mapper.toDomain
import com.kainzengaming.sport.sports.data.remote.RemoteDataSource
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.domain.repository.SportsRepository
import javax.inject.Inject

class SportsRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    SportsRepository {

    override suspend fun getSports(): List<Sport> =
        remoteDataSource.getSports()
            .filter {
                it.name != null
            }
            .map {
                it.toDomain()
            }
}