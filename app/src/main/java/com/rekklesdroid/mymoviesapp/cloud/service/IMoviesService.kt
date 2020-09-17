package com.rekklesdroid.mymoviesapp.cloud.service

import com.example.cloud.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IMoviesService {

	@GET("movie/popular")
	suspend fun getMovies(
		@Query("api_key") api_key: String = "2a0bb9bbed23bca3788ffb6324326703",
		@Query("page") page: Int
	): MoviesResponse
}