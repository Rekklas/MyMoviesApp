package com.example.cloud.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rekklesdroid.mymoviesapp.cloud.model.MovieModel

class MoviesResponse {

	@SerializedName("page")
	@Expose
	var page: Int? = null
		private set
	@SerializedName("total_results")
	@Expose
	var totalResults: Int? = null
		private set
	@SerializedName("total_pages")
	@Expose
	var totalPages: Int? = null
		private set
	@SerializedName("results")
	@Expose
	var results: List<MovieModel>? = null
		private set
}