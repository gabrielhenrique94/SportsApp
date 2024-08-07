package com.kainzengaming.sport.sports.data.remote.model

import com.google.gson.annotations.SerializedName

data class EventDto(
    @SerializedName("i") val id: String,
    @SerializedName("si") val sportId: String,
    @SerializedName("d") val name: String,
    @SerializedName("tt") val startTime: Long
)
