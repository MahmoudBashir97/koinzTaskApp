package com.mahmoudbashir.koinztask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos_table")
data class Photos(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Int,
    @ColumnInfo(name = "page_number")
    val page: Int,
    @ColumnInfo(name = "pages_count")
    val pages: Int,
    @ColumnInfo(name = "per_page")
    val perpage: Int,
    @ColumnInfo(name = "photo_list")
    val photo: List<Photo>,
    @ColumnInfo(name = "total")
    val total: Int
)