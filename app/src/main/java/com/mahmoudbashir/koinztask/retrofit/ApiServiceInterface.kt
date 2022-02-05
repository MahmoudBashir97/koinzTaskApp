package com.mahmoudbashir.koinztask.retrofit

import com.mahmoudbashir.koinztask.model.Root
import com.mahmoudbashir.koinztask.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceInterface {

    //nojsoncallback=50&text=Color&page=1&per_page=20&
    //services/rest/?method=flickr.photos.search
    //services/rest/?method=flickr.photos.getRecent
    @GET("services/rest/?method=flickr.photos.search")
     suspend fun getPhotosData(
        @Query("api_key")
        api_key:String = Constants.APIKEY,
        @Query("format")
        format:String = "json",
        @Query("nojsoncallback")
        nojsoncallback:String="50",
        @Query("text")
        text:String = "Color",
        @Query("page")
        page:Int = 1,
    ):Response<Root>

}