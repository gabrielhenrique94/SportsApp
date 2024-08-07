package com.kainzengaming.sport.sports.domain.model

data class Sport(
    val id: String,
    val name: String,
    val events: List<Event>
)