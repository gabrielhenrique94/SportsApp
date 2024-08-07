package com.kainzengaming.sport.sports.presentation.adapter.mapper

import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.presentation.adapter.model.EventHolder
import com.kainzengaming.sport.sports.presentation.adapter.model.EventsHolder
import com.kainzengaming.sport.sports.presentation.adapter.model.Holder
import com.kainzengaming.sport.sports.presentation.adapter.model.SportHolder

fun List<Sport>.toSportHolderList(): List<Holder> {
    val holderList = mutableListOf<Holder>()
    for (sport in this) {
        holderList.add(sport.toSportHolder())
        holderList.add(sport.toEventsHolder())
    }
    return holderList
}

fun Sport.toEventsHolder() = EventsHolder(
    sportId = id,
    events = events.map { it.toEventHolder() }
)

fun Sport.toSportHolder() = SportHolder(
    id = id,
    name = name,
    events = events.map { it.toEventHolder() },
    isOpened = true
)

fun Event.toEventHolder() = EventHolder(
    id = id,
    name = name,
    startTime = startTime,
    isFavorite = isFavorite
)

fun SportHolder.toEventsHolder() = EventsHolder(
    sportId = id,
    events = events
)

fun EventHolder.toEvent() = Event(
    id = id,
    name = name,
    startTime = startTime,
    isFavorite = isFavorite
)