package com.kainzengaming.sport.sports.presentation.adapter.model

data class EventsHolder(
    val sportId: String,
    val events: List<EventHolder>
) : Holder
