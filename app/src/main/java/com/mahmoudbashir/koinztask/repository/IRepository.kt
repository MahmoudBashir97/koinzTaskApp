package com.mahmoudbashir.koinztask.repository

import com.mahmoudbashir.koinztask.model.Root
import retrofit2.Response

interface IRepository {
    suspend fun getPhotosDataFromServer(): Response<Root>
}