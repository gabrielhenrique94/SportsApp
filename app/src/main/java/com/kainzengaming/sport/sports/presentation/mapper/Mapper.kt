package com.kainzengaming.sport.sports.presentation.adapter.mapper

import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.presentation.model.EventDataUi
import com.kainzengaming.sport.sports.presentation.model.EventsHolder
import com.kainzengaming.sport.sports.presentation.model.Holder
import com.kainzengaming.sport.sports.presentation.model.SportDataUi

fun List<Sport>.toDataUi(): List<Any> {
    val holderList = mutableListOf<Any>()
    for (sport in this) {
        holderList.add(sport.toSportDataUi())
        holderList.add(sport.toEventsDataUi())
    }
    return holderList
}

fun Sport.toEventsDataUi() = EventsHolder(
    sportId = id,
    events = events.map { it.toEventDataUi(id) }
)

fun Sport.toSportDataUi() = SportDataUi(
    id = id,
    name = name,
    events = events.map { it.toEventDataUi(id) },
    isOpened = true
)

fun Event.toEventDataUi(sportId: String) = EventDataUi(
    id = id,
    name = name,
    startTime = startTime,
    isFavorite = isFavorite,
    sportId = sportId
)

fun SportDataUi.toEventsDataUi() =
    EventsHolder(
        sportId = id,
        events = if (this.isFiltered) events.filter { it.isFavorite } else events
    )

fun EventDataUi.toEvent() = Event(
    id = id,
    name = name,
    startTime = startTime,
    isFavorite = isFavorite
)