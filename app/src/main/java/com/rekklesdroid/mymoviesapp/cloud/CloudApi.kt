package com.rekklesdroid.mymoviesapp.cloud

import com.google.gson.GsonBuilder
import com.rekklesdroid.mymoviesapp.cloud.service.GenresService
import com.rekklesdroid.mymoviesapp.cloud.service.IGenresService
import com.rekklesdroid.mymoviesapp.cloud.service.IMoviesService
import com.rekklesdroid.mymoviesapp.cloud.service.MoviesService
import com.rekklesdroid.mymoviesapp.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class CloudApi {

	val movies: MoviesService
	val genres: GenresService

	init {
		val gson = GsonBuilder()
			.setLenient()
			.create()

		val okHttp = OkHttpClient.Builder()
			.readTimeout(30, TimeUnit.SECONDS)
			.writeTimeout(30, TimeUnit.SECONDS)
			.connectTimeout(30, TimeUnit.SECONDS)
			.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
			.build()

		val retrofit = Retrofit.Builder()
			.baseUrl(Constants.BASE_URL)
			.client(okHttp)
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build()

		movies = MoviesService(retrofit.create(IMoviesService::class.java))
		genres = GenresService(retrofit.create(IGenresService::class.java))
	}
}