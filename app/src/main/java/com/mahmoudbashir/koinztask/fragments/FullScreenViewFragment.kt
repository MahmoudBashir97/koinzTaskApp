package com.mahmoudbashir.koinztask.fragments

import android.content.Context
import android.os.Bundle
import android.os.NetworkOnMainThreadException
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.mahmoudbashir.koinztask.databinding.FragmentFullScreenViewBinding
import com.mahmoudbashir.koinztask.ui.MainActivity
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.fragment.navArgs
import com.mahmoudbashir.koinztask.R


class FullScreenViewFragment : Fragment() {

    lateinit var fullBinding : FragmentFullScreenViewBinding
    var  isImageFitToScreen:Boolean = false

    val args:FullScreenViewFragmentArgs by navArgs()
    var photoUrl:String =""

    override fun onAttach(context: Context) {
        super.onAttach(context)

        //todo receiving photo Url to be attached to ImageView
        photoUrl = args.photoUrl
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fullBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_full_screen_view, container, false)


        return fullBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        try {
            //todo attach photoUrl to ImageView by Using Glide Library
            fullBinding.apply {
                Glide.with((activity as MainActivity)).load(photoUrl).into(photoView)
            }
        }catch (e:NetworkOnMainThreadException){
            e.message
        }

        doFullScreenForImgV()
    }

    //todo applying FullScreen to ImageView
    private fun doFullScreenForImgV() {
        if (isImageFitToScreen) {
            isImageFitToScreen = false
            fullBinding.photoView.layoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            fullBinding.photoView.adjustViewBounds = true
        } else {
            isImageFitToScreen = true
            fullBinding.photoView.layoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
                )
            fullBinding.photoView.scaleType = ImageView.ScaleType.FIT_XY
        }
    }

    private fun hideSystemBars() {
        val windowInsetsController =
            ViewCompat.getWindowInsetsController((activity as MainActivity).window.decorView) ?: return
        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }

}