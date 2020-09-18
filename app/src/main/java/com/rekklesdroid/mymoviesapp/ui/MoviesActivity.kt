package com.rekklesdroid.mymoviesapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rekklesdroid.mymoviesapp.R
import com.rekklesdroid.mymoviesapp.utils.extensions.gone
import com.rekklesdroid.mymoviesapp.utils.extensions.show
import com.rekklesdroid.mymoviesapp.utils.extensions.toast
import kotlinx.android.synthetic.main.activity_movies.*
import org.koin.android.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {

    private lateinit var adapter: VerticalRvAdapter
    private val viewModel: MoviesViewModel by viewModel()
    private var loading = false
    private var totalPages = 0
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        initAdapter()
        initViewModel()
    }

    private fun initViewModel() {
        startLoading()
        viewModel.initialize()
        viewModel.movies.observe(this, Observer { list ->
            finishLoading()
            adapter.updateData(list)
        })

        viewModel.failureLiveData.observe(this, Observer { bool ->
            if (!bool) return@Observer
            finishLoading()
            this.toast(R.string.something_went_wrong)
        })

        viewModel.pagination.observe(this, Observer { pair ->
            totalPages = pair.second
        })
    }

    private fun finishLoading() {
        pb.gone()
        loading = false
    }

    private fun startLoading() {
        pb.show()
        loading = true
    }

    private fun initAdapter() {
        adapter = VerticalRvAdapter()
        val manager = LinearLayoutManager(this)
        rv.adapter = adapter
        rv.layoutManager = manager

        rv.addOnScrollListener(object : PaginationScrollListener(manager) {
            override val isLastPage: Boolean
                get() = currentPage == totalPages
            override val isLoading: Boolean
                get() = loading

            override fun loadMoreItems() {
                startLoading()
                viewModel.fetchMovies()
            }
        })
    }
}