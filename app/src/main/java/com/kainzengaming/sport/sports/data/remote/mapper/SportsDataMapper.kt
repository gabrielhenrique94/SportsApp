package com.kainzengaming.sport.sports.data.remote.mapper

import com.kainzengaming.sport.sports.data.local.model.FavoriteEvent
import com.kainzengaming.sport.sports.data.remote.model.EventDto
import com.kainzengaming.sport.sports.data.remote.model.SportDto
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport


fun EventDto.toDomain(favoriteEvents: List<FavoriteEvent>): Event =
    Event(
        id = id,
        name = name,
        startTime = startTime,
        isFavorite = favoriteEvents.any { it.eventId == id }
    )

fun List<EventDto>.toDomain(favoriteEvents: List<FavoriteEvent>): List<Event> =
    map { it.toDomain(favoriteEvents) }

fun SportDto.toDomain(favoriteEvents: List<FavoriteEvent>): Sport =
    Sport(
        id = id,
        name = name.orEmpty(),
        events = events.toDomain(favoriteEvents)
    )
