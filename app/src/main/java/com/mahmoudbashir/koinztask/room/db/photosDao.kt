package com.mahmoudbashir.koinztask.room.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mahmoudbashir.koinztask.model.Photo
import com.mahmoudbashir.koinztask.model.Photos

@Dao
interface photosDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(ph:Photo)

    @Query("SELECT * FROM photo_table ORDER by photoId ASC")
    fun getPhotosDataFromLocal():LiveData<List<Photo>>


    @Delete
    suspend fun deletePhotoItem(ph:Photo)

}