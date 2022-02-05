package com.mahmoudbashir.koinztask.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    val viewModel by inject<appViewModel>()
    lateinit var photoAdpt : photosAdapter



    override fun onAttach(context: Context) {
        super.onAttach(context)

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
       // gettingPhotoData()
       getPhotoListFromLocal()

    }

  /*  private fun gettingPhotoData() {
        homeBinding.isLoading = true
        viewModel.data.observe(viewLifecycleOwner,{root->
            if (root != null){

                viewModel.data.observe(viewLifecycleOwner,{
                    photolist->
                    if (photolist.isNotEmpty()){
                     homeBinding.isLoading = false
                     photoAdpt.differ.submitList(photolist)
                    }
                })
            }
        })
    }*/

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

    private fun setUpRecyclerView() {
        photoAdpt = photosAdapter((activity as MainActivity),this)
        homeBinding.recPhotosList.apply {
            setHasFixedSize(true)
            adapter = photoAdpt
        }
    }

    override fun onClickedItem(photUrl: String) {
        Log.d("urls : ",photUrl)
        findNavController().navigate(HomeScreenFragmentDirections.actionHomeScreenFragmentToFullScreenViewFragment(photUrl))
    }

}