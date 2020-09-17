package com.rekklesdroid.mymoviesapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rekklesdroid.mymoviesapp.R
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {

    private val viewModel: MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
    }
}