package com.rekklesdroid.mymoviesapp.cloud.service

import com.rekklesdroid.mymoviesapp.cloud.model.GenresResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IGenresService {

	@GET("genre/movie/list")
	suspend fun getGenres(
		@Query("api_key") api_key: String = "2a0bb9bbed23bca3788ffb6324326703"): GenresResponse
}