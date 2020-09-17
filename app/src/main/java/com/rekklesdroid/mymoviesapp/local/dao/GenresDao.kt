package com.rekklesdroid.mymoviesapp.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.rekklesdroid.mymoviesapp.local.model.Genre
import kotlinx.coroutines.flow.Flow

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
@Dao
abstract class GenresDao : BaseDao<Genre>(Genre::class.java){

    @Query("SELECT * FROM genre ")
    abstract fun observeGenres(): Flow<List<Genre>>
}