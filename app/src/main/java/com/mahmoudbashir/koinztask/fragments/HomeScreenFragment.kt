package com.mahmoudbashir.koinztask.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.mahmoudbashir.koinztask.R
import com.mahmoudbashir.koinztask.adapters.photosAdapter
import com.mahmoudbashir.koinztask.databinding.FragmentHomeScreenBinding
import com.mahmoudbashir.koinztask.ui.MainActivity
import com.mahmoudbashir.koinztask.viewModel.appViewModel
import org.koin.android.ext.android.inject


class HomeScreenFragment : Fragment() , photosAdapter.IClicked{

    lateinit var homeBinding: FragmentHomeScreenBinding

    //todo initializing viewModel by inject (koin Di)
    val viewModel by inject<appViewModel>()
    lateinit var photoAdpt : photosAdapter


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
       getPhotoListFromLocal()

    }


    //todo here we are getting Photo data , stored in local (room db)
    private fun getPhotoListFromLocal(){
        homeBinding.isLoading = true
        viewModel.getStoredPhotosData().observe(viewLifecycleOwner,{
            photolist ->
            if (photolist.isNotEmpty()){
                homeBinding.isLoading = false
                photoAdpt.differ.submitList(photolist)
            }
        })
    }

    //todo here we initializing photoAdapter , and work on recyclerview
    private fun setUpRecyclerView() {
        photoAdpt = photosAdapter((activity as MainActivity),this)
        homeBinding.recPhotosList.apply {
            setHasFixedSize(true)
            adapter = photoAdpt
        }
    }

    //todo clicking on One Item then navigate to FullScreen Fragment to view Full Image.
    override fun onClickedItem(photUrl: String) {
        Log.d("urls : ",photUrl)
        findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToFullScreenViewFragment(photUrl))
    }

}