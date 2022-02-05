package com.mahmoudbashir.koinztask.room.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mahmoudbashir.koinztask.model.Photo
import com.mahmoudbashir.koinztask.model.Photos

@Dao
interface photosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(ph:Photos)

    @Query("SELECT photo_list FROM photos_table ORDER by id")
    suspend fun getPhotosDataFromLocal():LiveData<List<Photo>>


}