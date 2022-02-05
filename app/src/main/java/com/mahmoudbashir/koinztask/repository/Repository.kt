package com.mahmoudbashir.koinztask.repository

import androidx.lifecycle.LiveData
import com.mahmoudbashir.koinztask.model.Photo
import com.mahmoudbashir.koinztask.model.Photos
import com.mahmoudbashir.koinztask.model.Root
import com.mahmoudbashir.koinztask.retrofit.RetrofitInstance
import com.mahmoudbashir.koinztask.room.db.photoDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response

class Repository(private val retroInstance:RetrofitInstance,private val db:photoDatabase): IRepository {

    override suspend fun getPhotosDataFromServer(): Response<Root> = retroInstance.api.getPhotosData()

    override suspend fun insertPhotosToLocal(ph: Photo) {
        GlobalScope.launch {
            db.dao().insertPhoto(ph)
        }
    }

    override  fun getPhotosDataFromLocal(): LiveData<List<Photo>> = db.dao().getPhotosDataFromLocal()
}