package com.kainzengaming.sport.sports.domain.model

data class Event(
    val id: String,
    val name: String,
    val startTime: Long,
    val isFavorite: Boolean = false
)
