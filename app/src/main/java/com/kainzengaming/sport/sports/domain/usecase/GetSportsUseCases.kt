package com.kainzengaming.sport.sports.domain.usecase

import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.domain.repository.SportsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSportsUseCases @Inject constructor(private val repository: SportsRepository) {
    suspend operator fun invoke(): Flow<List<Sport>> = repository.getSports()
}