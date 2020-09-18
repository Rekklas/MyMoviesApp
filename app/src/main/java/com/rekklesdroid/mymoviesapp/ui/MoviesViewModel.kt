package com.rekklesdroid.mymoviesapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rekklesdroid.mymoviesapp.local.model.Movies
import com.rekklesdroid.mymoviesapp.repo.MoviesRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
class MoviesViewModel(
    private val moviesRepo: MoviesRepository
) : ViewModel() {

    val movies = MutableLiveData<List<Movies>>()
    val failureLiveData = moviesRepo.failureLiveData
    val pagination	 = moviesRepo.pagination

    fun initialize() {
        viewModelScope.launch {

            launch {
                moviesRepo.observeMovies().collect { data ->
                    movies.value = data.sortedBy { it.id }
                }
            }

            viewModelScope.launch {
                moviesRepo.getGenres()
            }.join()

            fetchMovies()
        }
    }

    fun fetchMovies(offset: Int = 10) =
        viewModelScope.launch {
            moviesRepo.getMovies(offset)
        }
}