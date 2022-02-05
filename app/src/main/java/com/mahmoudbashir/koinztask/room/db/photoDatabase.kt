package com.mahmoudbashir.koinztask.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahmoudbashir.koinztask.model.Photo


@Database(entities = [Photo::class], version = 1, exportSchema = false)
abstract class photoDatabase : RoomDatabase(){

    abstract fun dao():photosDao
}