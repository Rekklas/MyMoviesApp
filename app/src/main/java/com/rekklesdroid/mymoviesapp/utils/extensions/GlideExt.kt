package com.rekklesdroid.mymoviesapp.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.rekklesdroid.mymoviesapp.R

fun ImageView.loadWithGlide(url: String) {
	Glide.with(context)
		.load(url)
		.centerCrop()
		.placeholder(context.getDrawable(R.drawable.ic_video_camera))
		.into(this)
}