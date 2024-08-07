package com.kainzengaming.sport.sports.presentation.adapter.model

data class EventHolder(
    val id: String,
    val name: String,
    val startTime: Long,
    val isFavorite: Boolean = false
): Holder
