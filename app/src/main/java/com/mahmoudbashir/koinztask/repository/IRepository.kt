package com.mahmoudbashir.koinztask.repository

import androidx.lifecycle.LiveData
import com.mahmoudbashir.koinztask.model.Photo
import com.mahmoudbashir.koinztask.model.Photos
import com.mahmoudbashir.koinztask.model.Root
import retrofit2.Response

interface IRepository {

    suspend fun getPhotosDataFromServer(): Response<Root>

    suspend fun insertPhotosToLocal(ph:Photo)
    fun getPhotosDataFromLocal():LiveData<List<Photo>>
}