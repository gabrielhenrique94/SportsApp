package com.kainzengaming.sport.sports.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kainzengaming.sport.sports.data.local.model.FavoriteEvent

@Dao
interface FavoriteEventsDao {
    @Query("SELECT * FROM favorite_events")
    suspend fun getAll(): List<FavoriteEvent>

    @Query("SELECT * FROM favorite_events WHERE event_id = :eventId")
    suspend fun getFavoriteEvent(eventId: String): List<FavoriteEvent>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteEvent: FavoriteEvent)

    @Delete
    suspend fun delete(favoriteEvent: FavoriteEvent)
}