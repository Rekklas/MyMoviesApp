package com.rekklesdroid.mymoviesapp.repo

import com.rekklesdroid.mymoviesapp.cloud.CloudApi
import com.rekklesdroid.mymoviesapp.local.AppDatabase

/**
 * Created on 9/18/2020 by eduard.kovalchuk
 */
class MoviesRepository(private val database: AppDatabase, private val cloud: CloudApi) {
}