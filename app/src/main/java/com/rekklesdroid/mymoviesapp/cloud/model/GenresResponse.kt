package com.rekklesdroid.mymoviesapp.cloud.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GenresResponse {

	@SerializedName("genres")
	@Expose
	var genres: List<GenreModel>? = null
		private set
}