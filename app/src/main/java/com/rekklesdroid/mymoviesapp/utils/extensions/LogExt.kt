package com.rekklesdroid.mymoviesapp.utils.extensions

import android.util.Log

fun Any.logd(message: String){
	Log.d(this.javaClass.simpleName, message)
}

fun Any.loge(message: String){
	Log.e(this.javaClass.simpleName, message)
}
