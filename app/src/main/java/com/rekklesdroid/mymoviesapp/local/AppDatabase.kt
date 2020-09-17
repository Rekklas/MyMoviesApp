package com.rekklesdroid.mymoviesapp.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rekklesdroid.mymoviesapp.local.dao.GenresDao
import com.rekklesdroid.mymoviesapp.local.dao.MoviesDao
import com.rekklesdroid.mymoviesapp.local.model.Genre
import com.rekklesdroid.mymoviesapp.local.model.Movies

@TypeConverters(DatabaseConverters::class)
@Database(entities = [Genre::class, Movies::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val genresDao: GenresDao
    abstract val moviesDao: MoviesDao
}