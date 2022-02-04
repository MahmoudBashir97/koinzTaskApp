package com.mahmoudbashir.koinztask.koin

import com.mahmoudbashir.koinztask.repository.Repository
import com.mahmoudbashir.koinztask.retrofit.RetrofitInstance
import com.mahmoudbashir.koinztask.viewModel.appViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitInstance() }
    single { Repository(get()) }

}

val mainViewModel = module {

    viewModel {
        appViewModel(get())
    }

}

