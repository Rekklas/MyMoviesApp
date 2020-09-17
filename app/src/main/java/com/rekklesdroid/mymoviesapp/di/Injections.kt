package com.rekklesdroid.mymoviesapp.di

import android.app.Application
import androidx.room.Room
import com.rekklesdroid.mymoviesapp.cloud.CloudApi
import com.rekklesdroid.mymoviesapp.local.AppDatabase
import com.rekklesdroid.mymoviesapp.ui.MoviesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initInjections(application: Application) {

	val viewModels = module {
		viewModel { MoviesViewModel() }
	}

	val repository = module {
		single {
			Room.databaseBuilder(get(), AppDatabase::class.java, "database")
				.build()
		}

	}

	val services = module {
		single { CloudApi() }
	}

	startKoin {
		androidContext(application)
	}
}
