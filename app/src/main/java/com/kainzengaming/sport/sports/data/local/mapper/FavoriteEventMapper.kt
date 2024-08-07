package com.kainzengaming.sport.sports.data.local.mapper

import com.kainzengaming.sport.sports.data.local.model.FavoriteEvent
import com.kainzengaming.sport.sports.domain.model.Event

fun Event.toFavoriteEvent(): FavoriteEvent = FavoriteEvent(
    eventId = id
)