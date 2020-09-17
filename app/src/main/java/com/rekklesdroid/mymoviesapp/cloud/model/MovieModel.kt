package com.rekklesdroid.mymoviesapp.cloud.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieModel {

	@SerializedName("popularity")
	@Expose
	var popularity: Double? = null
		private set
	@SerializedName("vote_count")
	@Expose
	var voteCount: Int? = null
		private set
	@SerializedName("video")
	@Expose
	var video: Boolean? = null
		private set
	@SerializedName("poster_path")
	@Expose
	var posterPath: String? = null
		private set
	@SerializedName("id")
	@Expose
	var id: Int? = null
		private set
	@SerializedName("adult")
	@Expose
	var adult: Boolean? = null
		private set
	@SerializedName("backdrop_path")
	@Expose
	var backdropPath: String? = null
		private set
	@SerializedName("original_language")
	@Expose
	var originalLanguage: String? = null
		private set
	@SerializedName("original_title")
	@Expose
	var originalTitle: String? = null
		private set
	@SerializedName("genre_ids")
	@Expose
	var genreIds: List<Int>? = null
		private set
	@SerializedName("title")
	@Expose
	var title: String? = null
		private set
	@SerializedName("vote_average")
	@Expose
	var voteAverage: Double? = null
		private set
	@SerializedName("overview")
	@Expose
	var overview: String? = null
		private set
	@SerializedName("release_date")
	@Expose
	var releaseDate: String? = null
		private set

}