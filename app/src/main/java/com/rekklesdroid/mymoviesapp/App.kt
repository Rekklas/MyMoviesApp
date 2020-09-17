package com.rekklesdroid.mymoviesapp

import android.app.Application
import com.rekklesdroid.mymoviesapp.di.initInjections

class App : Application() {
	override fun onCreate() {
		super.onCreate()
		initInjections(this)
	}
}