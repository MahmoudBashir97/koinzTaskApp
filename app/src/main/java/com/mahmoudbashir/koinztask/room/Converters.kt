package com.mahmoudbashir.koinztask.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mahmoudbashir.koinztask.model.Photo

class Converters {

    @TypeConverter
    public fun fromPhotoListToString(photolist: List<Photo>): String? {
        return Gson().toJson(photolist)
    }

    @TypeConverter
    public fun fromStringToPhotoList(stPhoto: String): List<Photo> {
        val listType = object :TypeToken<List<Photo>>() {}.type
        return Gson().fromJson(stPhoto,listType)
    }
}