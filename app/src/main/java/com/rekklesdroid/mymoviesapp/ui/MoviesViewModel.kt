package com.rekklesdroid.mymoviesapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rekklesdroid.mymoviesapp.local.model.Movies
import com.rekklesdroid.mymoviesapp.repo.MoviesRepository

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
class MoviesViewModel(
    private val moviesRepo: MoviesRepository
) : ViewModel() {

    val movies = MutableLiveData<List<Movies>>()
}