package com.mahmoudbashir.koinztask.model

import androidx.room.ColumnInfo

data class Photo(
    @ColumnInfo(name = "farm")
    val farm: Int,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "isfamily")
    val isfamily: Int,
    @ColumnInfo(name = "isfriend")
    val isfriend: Int,
    @ColumnInfo(name = "ispublic")
    val ispublic: Int,
    @ColumnInfo(name = "owner")
    val owner: String,
    @ColumnInfo(name = "secret")
    val secret: String,
    @ColumnInfo(name = "server")
    val server: String,
    @ColumnInfo(name = "title")
    val title: String
)