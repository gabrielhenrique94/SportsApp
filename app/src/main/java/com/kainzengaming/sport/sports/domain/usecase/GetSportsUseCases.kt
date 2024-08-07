package com.kainzengaming.sport.sports.domain.usecase

import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.domain.repository.SportsRepository
import javax.inject.Inject

class GetSportsUseCases @Inject constructor(private val repository: SportsRepository) {
    suspend operator fun invoke(filter: Boolean): List<Sport> {
        val sports = repository.getSports()
        return if (filter) {
            sports
                .map { sport ->
                    sport.copy(events = sport.events.filter { event ->
                        event.isFavorite
                    })
                }.filter {
                    it.events.any { event -> event.isFavorite }
                }
        } else {
            sports
        }
    }
}