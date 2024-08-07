package com.kainzengaming.sport.sports.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_events")
data class FavoriteEvent(
    @PrimaryKey
    @ColumnInfo(name = "event_id") val eventId: String
)