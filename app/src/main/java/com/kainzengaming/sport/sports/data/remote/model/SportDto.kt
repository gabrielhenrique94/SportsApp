package com.kainzengaming.sport.sports.data.remote.model

import com.google.gson.annotations.SerializedName

data class SportDto(
    @SerializedName("i") val id: String,
    @SerializedName("d") val name: String?,
    @SerializedName("e") val events: List<EventDto>
)
