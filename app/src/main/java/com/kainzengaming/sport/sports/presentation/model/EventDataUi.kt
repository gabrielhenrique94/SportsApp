package com.kainzengaming.sport.sports.presentation.adapter.model

data class EventHolder(
    val id: String,
    val name: String,
    val startTime: Long,
    val sportId: String,
    var isFavorite: Boolean = false
) : Holder
