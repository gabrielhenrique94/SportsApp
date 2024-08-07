package com.kainzengaming.sport.sports.data.mapper

import com.kainzengaming.sport.sports.data.model.EventDto
import com.kainzengaming.sport.sports.data.model.SportDto
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport


fun EventDto.toDomain(): Event =
    Event(
        id = id,
        name = name,
        startTime = startTime,
        isFavorite = false
    )

fun List<EventDto>.toDomain(): List<Event> =
    map { it.toDomain() }

fun SportDto.toDomain(): Sport =
    Sport(
        id = id,
        name = name.orEmpty(),
        events = events.toDomain()
    )
