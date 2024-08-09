package com.kainzengaming.sport.sports.domain.usecase

import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.repository.SportsRepository
import javax.inject.Inject

class FavoriteEventUseCase @Inject constructor(private val repository: SportsRepository) {
    suspend operator fun invoke(event: Event) {
        if (!event.isFavorite) {
            repository.favoriteEvent(event)
        } else {
            repository.removeFavoriteEvent(event)
        }
    }
}