package com.kainzengaming.sport.sports.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kainzengaming.sport.sports.data.local.database.dao.FavoriteEventsDao
import com.kainzengaming.sport.sports.data.local.model.FavoriteEvent

@Database(entities = [FavoriteEvent::class], version = 1)
abstract class SportsDatabase : RoomDatabase() {
    abstract fun eventsDao(): FavoriteEventsDao

    companion object {
        const val DATABASE_NAME = "sports_database"
    }

}