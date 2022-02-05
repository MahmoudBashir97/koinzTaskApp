package com.mahmoudbashir.koinztask.dataLocal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.mahmoudbashir.koinztask.room.db.photoDatabase
import com.mahmoudbashir.koinztask.room.db.photosDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest //to tell that is an Unit Test
class PhotoDaoTest {

    @get:Rule
    var instantTaskExecutorRule= InstantTaskExecutorRule()


    private lateinit var database:photoDatabase
    private lateinit var dao:photosDao

    @Before
    fun setUp(){
        // this is not a real database
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            photoDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.dao()
    }



}