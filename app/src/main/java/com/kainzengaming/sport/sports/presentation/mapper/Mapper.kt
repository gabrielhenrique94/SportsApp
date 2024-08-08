package com.kainzengaming.sport.sports.presentation.mapper

import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.presentation.model.EventDataUi
import com.kainzengaming.sport.sports.presentation.model.EventsDataUi
import com.kainzengaming.sport.sports.presentation.model.SportDataUi

fun List<Sport>.toDataUi(): List<Any> {
    val holderList = mutableListOf<Any>()
    for (sport in this) {
        holderList.add(sport.toSportDataUi())
        holderList.add(sport.toEventsDataUi())
    }
    return holderList
}

fun Sport.toEventsDataUi() = EventsDataUi(
    sportId = id,
    events = events.map { it.toEventDataUi(id) }.toMutableList()
)

fun Sport.toSportDataUi() = SportDataUi(
    id = id,
    name = name,
    events = events.map { it.toEventDataUi(id) }.toMutableList(),
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
    EventsDataUi(
        sportId = id,
        events = if (this.isFiltered)
            events.filter { it.isFavorite }
        else
            ArrayList(events)
    )

fun EventDataUi.toEventDomain() = Event(
    id = id,
    name = name,
    startTime = startTime,
    isFavorite = isFavorite
)