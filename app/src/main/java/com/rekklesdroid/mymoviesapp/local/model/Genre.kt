package com.rekklesdroid.mymoviesapp.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre")
data class Genre(

	@PrimaryKey
	@ColumnInfo(name = "id")
	val id: Int = 0,

	@ColumnInfo(name = "name")
	val name: String = ""
)
