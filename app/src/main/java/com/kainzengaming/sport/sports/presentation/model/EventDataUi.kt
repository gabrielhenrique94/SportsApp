package com.kainzengaming.sport.sports.presentation.model

data class EventDataUi(
    val id: String,
    val name: String,
    val startTime: Long,
    val sportId: String,
    val isFavorite: Boolean = false
)
