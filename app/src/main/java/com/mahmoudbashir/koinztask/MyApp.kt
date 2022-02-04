package com.mahmoudbashir.koinztask

import android.app.Application
import com.mahmoudbashir.koinztask.koin.dataModule
import com.mahmoudbashir.koinztask.koin.mainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                dataModule,
                mainViewModel
            )
        }
    }
}