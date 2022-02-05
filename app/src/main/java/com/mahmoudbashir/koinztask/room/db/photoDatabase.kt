package com.mahmoudbashir.koinztask.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mahmoudbashir.koinztask.model.Photos
import com.mahmoudbashir.koinztask.room.Converters

@Database(entities = [Photos::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class photoDatabase : RoomDatabase(){

    abstract fun dao():photosDao
}