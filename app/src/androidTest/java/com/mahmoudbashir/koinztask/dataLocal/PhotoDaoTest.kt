package com.mahmoudbashir.koinztask.dataLocal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.mahmoudbashir.koinztask.model.Photo
import com.mahmoudbashir.koinztask.room.db.photoDatabase
import com.mahmoudbashir.koinztask.room.db.photosDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import com.google.common.truth.Truth.assertThat
import org.junit.*
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

    @Test
    fun insertPhotoItem() = runBlockingTest {
        val photo = Photo(1,"1",1,0,2,"yes","123456","2234515","it is working good")

        dao.insertPhoto(photo)
        val allShoppingItems = dao.getPhotosDataFromLocal().getOrAwaitValue()

        assertThat(allShoppingItems).contains(photo)
    }

    @Test
    fun deleteShoppingItem() = runBlockingTest {
        val photo = Photo(1,"1",1,0,2,"yes","123456","2234515","it is working good")


        dao.insertPhoto(photo)
        dao.deletePhotoItem(photo)
        val allShoppingItems = dao.getPhotosDataFromLocal().getOrAwaitValue()

        assertThat(allShoppingItems).doesNotContain(photo)
    }



    @After
    fun teardown(){
        database.close()
    }




}