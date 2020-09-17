package com.rekklesdroid.mymoviesapp.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.rekklesdroid.mymoviesapp.local.model.Movies
import kotlinx.coroutines.flow.Flow

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
@Dao
abstract class MoviesDao : BaseDao<Movies>(Movies::class.java) {

    @Query("SELECT * FROM all_movies ")
    abstract fun observe(): Flow<List<Movies>>

    @Query("SELECT id FROM all_movies ORDER BY id DESC LIMIT 1")
    abstract suspend fun getLatestPage(): Int?

    @Query("DELETE FROM all_movies")
    abstract suspend fun deleteAll()
}