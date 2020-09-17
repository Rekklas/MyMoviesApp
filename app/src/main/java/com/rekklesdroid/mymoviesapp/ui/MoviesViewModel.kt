package com.rekklesdroid.mymoviesapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rekklesdroid.mymoviesapp.local.model.Movies

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
class MoviesViewModel : ViewModel() {

    val movies = MutableLiveData<List<Movies>>()
}