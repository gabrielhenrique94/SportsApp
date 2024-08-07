package com.kainzengaming.sport.sports.presentation.adapter.model

data class SportHolder(
    val id: String,
    val name: String,
    val events: List<EventHolder>,
    var isOpened: Boolean = false
) : Holder {
    val isFavorite: Boolean
        get() = events.all { event  ->  event.isFavorite }
}
