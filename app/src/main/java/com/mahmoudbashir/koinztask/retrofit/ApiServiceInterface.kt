package com.mahmoudbashir.koinztask.retrofit

import com.mahmoudbashir.koinztask.model.Root
import com.mahmoudbashir.koinztask.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceInterface {

    @GET("services/rest/?method=flickr.photos.getRecent")
     suspend fun getPhotosData(
        @Query("api_key")
        api_key:String = Constants.APIKEY,
        @Query("format")
        format:String = "json",
        @Query("nojsoncallback")
        nojsoncallback:String="1"
    ):Response<Root>

}