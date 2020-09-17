package com.rekklesdroid.mymoviesapp.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rekklesdroid.mymoviesapp.local.model.Movie

/**
 * Created on 9/17/2020 by eduard.kovalchuk
 */
class DatabaseConverters {

    @TypeConverter
    fun fromMovieList(value: List<Movie>): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun toMovieList(value: String): List<Movie> {
        val type = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(value, type)
    }
}