package com.mahmoudbashir.koinztask.dataLocal

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.mahmoudbashir.koinztask.retrofit.ApiServiceInterface
import com.mahmoudbashir.koinztask.utils.Constants
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

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ServiceTest {

    @Mock
    lateinit var apiService : ApiServiceInterface

    @Before
    internal fun setUp(){
        MockitoAnnotations.initMocks(this)
        val retrofit  = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiServiceInterface::class.java)
    }

    @Test
    internal fun getDataTest() = runBlockingTest{
        apiService.getPhotosData().apply {
            body()?.photos?.photo?.forEach(::println)
        }
    }
}