package com.kainzengaming.sport.sports.presentation.model

data class SportDataUi(
    val id: String,
    val name: String,
    val events: MutableList<EventDataUi>,
    val isOpened: Boolean = false,
    val isFiltered: Boolean = false
)
