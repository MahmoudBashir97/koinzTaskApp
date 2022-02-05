package com.mahmoudbashir.koinztask.koin

import android.app.Application
import androidx.room.Room
import com.mahmoudbashir.koinztask.repository.Repository
import com.mahmoudbashir.koinztask.retrofit.RetrofitInstance
import com.mahmoudbashir.koinztask.room.db.photoDatabase
import com.mahmoudbashir.koinztask.room.db.photosDao
import com.mahmoudbashir.koinztask.viewModel.appViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {


    fun providerDatabase(application: Application):photoDatabase{
        return Room.databaseBuilder(application,photoDatabase::class.java,"UserDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun providerDao(db:photoDatabase):photosDao{
        return db.dao()
    }

    single { providerDatabase(androidApplication()) }
    single { providerDao(get()) }
    single { RetrofitInstance() }
    single { Repository(get()) }

}

val mainViewModel = module {

    viewModel {
        appViewModel(get())
    }

}

