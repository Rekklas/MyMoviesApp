package com.rekklesdroid.mymoviesapp.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rekklesdroid.mymoviesapp.local.model.Movies

@TypeConverters(DatabaseConverters::class)
@Database(entities = [Movies::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
}