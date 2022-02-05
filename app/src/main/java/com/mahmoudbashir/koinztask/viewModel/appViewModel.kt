package com.mahmoudbashir.koinztask.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.koinztask.model.Photo
import com.mahmoudbashir.koinztask.model.Root
import com.mahmoudbashir.koinztask.repository.Repository
import kotlinx.coroutines.launch

class appViewModel(val repo:Repository): ViewModel() {

    val data:MutableLiveData<List<Photo>> = MutableLiveData()

    fun getData() = viewModelScope.launch {
        repo.getPhotosDataFromServer().apply {
            if (body() != null)
            {
                body()?.photos?.photo?.forEach{
                    ph-> insertDataToLocal(ph)
                }
            }
        }
    }

    fun insertDataToLocal(ph: Photo) = viewModelScope.launch {
        repo.insertPhotosToLocal(ph)
    }


   fun getStoredPhotosData():LiveData<List<Photo>> = repo.getPhotosDataFromLocal()

}