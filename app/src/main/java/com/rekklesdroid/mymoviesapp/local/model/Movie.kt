package com.rekklesdroid.mymoviesapp.local.model

import androidx.room.ColumnInfo

data class Movie(

	@ColumnInfo(name = "id")
	val id: Int = 0,

	@ColumnInfo(name = "popularity")
	val popularity: Double = 0.0,

	@ColumnInfo(name = "vote_count")
	val voteCount: Int = 0,

	@ColumnInfo(name = "video")
	val video: Boolean = false,

	@ColumnInfo(name = "poster_path")
	val posterPath: String = "",

	@ColumnInfo(name = "adult")
	val adult: Boolean = false,

	@ColumnInfo(name = "backdrop_path")
	val backdropPath: String = "",

	@ColumnInfo(name = "original_language")
	val originalLanguage: String = "",

	@ColumnInfo(name = "original_title")
	val originalTitle: String = "",

	@ColumnInfo(name = "genre_ids")
	val genres: List<String> = emptyList(),

	@ColumnInfo(name = "title")
	val title: String = "",

	@ColumnInfo(name = "vote_average")
	val voteAverage: Double = 0.0,

	@ColumnInfo(name = "overview")
	val overview: String = "",

	@ColumnInfo(name = "release_date")
	val releaseDate: String = ""
)