package com.rekklesdroid.mymoviesapp.cloud.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GenreModel {

	@SerializedName("id")
	@Expose
	var id: Int = 0
		private set
	@SerializedName("name")
	@Expose
	var name: String? = null
		private set

}