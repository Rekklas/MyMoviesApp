package com.rekklesdroid.mymoviesapp.utils.extensions

fun Int.toLongOrNull() = try {
	this.toLong()
} catch (e: Exception) {
	null
}