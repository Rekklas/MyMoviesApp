package com.rekklesdroid.mymoviesapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rekklesdroid.mymoviesapp.R
import com.rekklesdroid.mymoviesapp.local.model.Movies
import com.rekklesdroid.mymoviesapp.utils.extensions.diffUtils
import com.rekklesdroid.mymoviesapp.utils.extensions.toLongOrNull
import kotlinx.android.synthetic.main.view_holder_movies.view.*

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
class VerticalRvAdapter : RecyclerView.Adapter<VerticalRvAdapter.VerticalViewHolder>() {

    var data = mutableListOf<Movies>()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return data[position].id.toLongOrNull() ?: 0
    }

    fun updateData(newData: List<Movies>) {
        this.diffUtils(data, newData) { o, n -> o.id == n.id && o.results == n.results }
        data.clear()
        data.addAll(newData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        return VerticalViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_movies,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class VerticalViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Movies) {
            with(itemView.innerRv) {
                adapter = HorizontalRvAdapter().also { it.updateData(item.results) }
                layoutManager =
                    LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }
}