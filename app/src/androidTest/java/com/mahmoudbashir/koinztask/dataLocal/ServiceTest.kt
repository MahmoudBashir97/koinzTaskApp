package com.mahmoudbashir.koinztask.dataLocal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.mahmoudbashir.koinztask.retrofit.ApiServiceInterface
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.common.truth.Truth.assertThat
import org.junit.Rule


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
@SmallTest //to tell that is an Unit Test
class ServiceTest {

    @get:Rule
    var instantTaskExecutorRule= InstantTaskExecutorRule()

    @Mock
    lateinit var apiService : ApiServiceInterface

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        val retrofit  = Retrofit.Builder()
            .baseUrl("https://www.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiServiceInterface::class.java)
    }

    @Test
    fun getDataTest() = runBlockingTest{
        apiService.getPhotosData().apply {
            body()?.photos?.photo?.forEach(::println)
            val response = body()?.stat
            assertThat(response).isEqualTo("ok")
        }
    }
}