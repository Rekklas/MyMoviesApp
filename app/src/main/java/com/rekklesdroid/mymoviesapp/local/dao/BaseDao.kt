package com.rekklesdroid.mymoviesapp.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

abstract class BaseDao<T>(val clazz: Class<T>) {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	abstract suspend fun insert(item: T): Long

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	abstract suspend fun insert(vararg items: T): LongArray

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	abstract suspend fun insert(items: Collection<T>): LongArray

	@Update
	abstract suspend fun update(item: T)

	@Delete
	abstract suspend fun delete(item: T)
}