package com.mahmoudbashir.koinztask.repository

import com.mahmoudbashir.koinztask.model.Root
import com.mahmoudbashir.koinztask.retrofit.RetrofitInstance
import retrofit2.Response

class Repository(private val retroInstance:RetrofitInstance): IRepository {
    override suspend fun getPhotosDataFromServer(): Response<Root> = retroInstance.api.getPhotosData()
}