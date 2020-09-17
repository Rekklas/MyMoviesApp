package com.rekklesdroid.mymoviesapp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun initInjections(application: Application) {

	startKoin {
		androidContext(application)
	}
}
