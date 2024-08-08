package com.kainzengaming.sport.sports.presentation.adapter.model

data class SportHolder(
    val id: String,
    val name: String,
    val events: List<EventHolder>,
    var isOpened: Boolean = false,
    var isFiltered: Boolean = false
) : Holder
