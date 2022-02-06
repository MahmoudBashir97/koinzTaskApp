package com.mahmoudbashir.koinztask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.mahmoudbashir.koinztask.R
import com.mahmoudbashir.koinztask.databinding.ActivityMainBinding
import com.mahmoudbashir.koinztask.viewModel.appViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    val viewModel by inject<appViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //todo get Data From api Server by viewModel once MainActivity created
        viewModel.getData()


    }
}