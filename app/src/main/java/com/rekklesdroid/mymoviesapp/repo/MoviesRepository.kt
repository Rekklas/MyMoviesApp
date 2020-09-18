package com.rekklesdroid.mymoviesapp.repo

import androidx.lifecycle.MutableLiveData
import com.example.cloud.model.MoviesResponse
import com.rekklesdroid.mymoviesapp.cloud.CloudApi
import com.rekklesdroid.mymoviesapp.cloud.model.GenreModel
import com.rekklesdroid.mymoviesapp.cloud.model.GenresResponse
import com.rekklesdroid.mymoviesapp.local.AppDatabase
import com.rekklesdroid.mymoviesapp.local.model.Genre
import com.rekklesdroid.mymoviesapp.local.model.Movie
import com.rekklesdroid.mymoviesapp.local.model.Movies
import com.rekklesdroid.mymoviesapp.utils.extensions.loge
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
class MoviesRepository(private val database: AppDatabase, private val cloud: CloudApi) {

    private var id: Int = 0
    private var genresMap = mapOf<Int, String>()

    val failureLiveData = MutableLiveData<Boolean>()
    val pagination = MutableLiveData<Pair<Int, Int>>()

    suspend fun getMovies(offset: Int) {
        val list = mutableListOf<Movies>()
        for (i in 0 until offset) {
            val page = getLatestPage().plus(i + 1)
            val moviesResponse = getMoviesSafely(page)
            pagination.postValue(Pair(moviesResponse.page ?: 0, moviesResponse.totalPages ?: 0))
            list.add(Movies(moviesResponse.page ?: 0, moviesResponse.results?.map {
                Movie(
                    id = ++id,
                    popularity = it.popularity ?: 0.0,
                    originalTitle = it.originalTitle.orEmpty(),
                    genres = it.genreIds?.map { id -> genresMap[id].orEmpty() } ?: emptyList(),
                    posterPath = it.posterPath.orEmpty())
            } ?: emptyList()))
        }
        insert(list)
    }

    private suspend fun getMoviesSafely(page: Int): MoviesResponse {
        try {
            return cloud.movies.getMovies(page = page)
        } catch (e: Exception) {
            loge(e.message.orEmpty())
            failureLiveData.postValue(true)
        }
        return MoviesResponse()
    }

    private suspend fun getLatestPage(): Int {
        try {
            return database.moviesDao.getLatestPage() ?: 0
        } catch (e: Exception) {
            loge("failed to get")
        }
        return 0
    }

    suspend fun getGenres() {
        val genres: List<GenreModel> = getGenresSafely().genres ?: emptyList()
        val list = genres.map { Genre(it.id, it.name.orEmpty()) }
        genresMap = list.associate { genre -> Pair(genre.id, genre.name) }
        insertGenres(list)
    }

    private suspend fun getGenresSafely(): GenresResponse {
        try {
            return cloud.genres.getGenres()
        } catch (e: Exception) {
            loge(e.message.orEmpty())
            failureLiveData.postValue(true)
        }
        return GenresResponse()
    }

    private suspend fun insertGenres(data: List<Genre>) {
        try {
            database.genresDao.insert(data)
        } catch (e: Exception) {
            loge("failed to insert")
        }
    }

    private suspend fun insert(data: List<Movies>) {
        try {
            database.moviesDao.insert(data)
        } catch (e: Exception) {
            loge("failed to insert")
        }
    }

    fun observeMovies(): Flow<List<Movies>> {
        try {
            return database.moviesDao.observe()
        } catch (e: Exception) {
            loge("failed to observe")
        }
        return emptyFlow()
    }
}