package com.mahmoudbashir.koinztask.repository

import androidx.lifecycle.LiveData
import com.mahmoudbashir.koinztask.model.Photo
import com.mahmoudbashir.koinztask.model.Photos
import com.mahmoudbashir.koinztask.model.Root
import com.mahmoudbashir.koinztask.retrofit.RetrofitInstance
import com.mahmoudbashir.koinztask.room.db.photoDatabase
import retrofit2.Response

class Repository(private val retroInstance:RetrofitInstance,private val db:photoDatabase): IRepository {

    override suspend fun getPhotosDataFromServer(): Response<Root> = retroInstance.api.getPhotosData()


    override suspend fun insertPhotosToLocal(ph: Photos) = db.dao().insertPhoto(ph)

    override suspend fun getPhotosDataFromLocal(): LiveData<List<Photo>> = db.dao().getPhotosDataFromLocal()
}