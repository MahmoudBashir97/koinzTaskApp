package com.mahmoudbashir.koinztask.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mahmoudbashir.koinztask.R
import com.mahmoudbashir.koinztask.databinding.FragmentHomeScreenBinding
import com.mahmoudbashir.koinztask.ui.MainActivity
import com.mahmoudbashir.koinztask.viewModel.appViewModel


class HomeScreenFragment : Fragment() {

    lateinit var homeBinding: FragmentHomeScreenBinding
    lateinit var viewModel:appViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
          viewModel =(activity as MainActivity).viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_home_screen, container, false)

        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

    }


}