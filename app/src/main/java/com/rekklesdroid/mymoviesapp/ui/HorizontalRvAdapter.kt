package com.rekklesdroid.mymoviesapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rekklesdroid.mymoviesapp.R
import com.rekklesdroid.mymoviesapp.local.model.Movie
import com.rekklesdroid.mymoviesapp.utils.Constants
import com.rekklesdroid.mymoviesapp.utils.extensions.diffUtils
import com.rekklesdroid.mymoviesapp.utils.extensions.loadWithGlide
import com.rekklesdroid.mymoviesapp.utils.extensions.toLongOrNull
import kotlinx.android.synthetic.main.view_holder_movie_card.view.*

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
class HorizontalRvAdapter : RecyclerView.Adapter<HorizontalRvAdapter.HorizontalViewHolder>() {

    var data = mutableListOf<Movie>()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return data[position].id.toLongOrNull() ?: 0
    }

    fun updateData(newData: List<Movie>) {
        this.diffUtils(data, newData) { o, n ->
            o.title == n.title &&
                    o.genres == n.genres &&
                    o.posterPath == n.posterPath &&
                    o.originalTitle == n.originalTitle
        }
        data.clear()
        data.addAll(newData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        return HorizontalViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_movie_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class HorizontalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Movie) {
            val genres = item.genres.joinToString(", ")
            itemView.img.loadWithGlide("${Constants.BASE_IMAGE_URL}${item.posterPath}")
            itemView.title.text = item.originalTitle
            itemView.tvGenres.text = genres
        }
    }
}