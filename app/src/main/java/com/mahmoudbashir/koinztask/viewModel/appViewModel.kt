package com.mahmoudbashir.koinztask.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.koinztask.model.Root
import com.mahmoudbashir.koinztask.repository.Repository
import kotlinx.coroutines.launch

class appViewModel(val repo:Repository): ViewModel() {

    val data:MutableLiveData<Root> = MutableLiveData()

    fun getData() = viewModelScope.launch {
        repo.getPhotosDataFromServer().apply {
            if (body() != null) data.postValue(body())
        }
    }


}