package com.mahmoudbashir.koinztask.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahmoudbashir.koinztask.R
import com.mahmoudbashir.koinztask.databinding.SingleItemPhotosBinding
import com.mahmoudbashir.koinztask.model.Photo

class photosAdapter : RecyclerView.Adapter<photosAdapter.ViewHolder>() {


    private val differCallback = object : DiffUtil.ItemCallback<Photo>(){
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)


    inner class ViewHolder(val itemBinding:SingleItemPhotosBinding) : RecyclerView.ViewHolder(itemBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(SingleItemPhotosBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photoItem =differ.currentList[position]

        holder.itemBinding.apply {

            val url = "https://farm${photoItem.farm}.static.flickr.com/${photoItem.server}/${photoItem.id}_${photoItem.secret}.jpg"
            Glide.with(holder.itemBinding.root).load(url).placeholder(R.drawable.ic_launcher_background).into(imgV)
        }

    }

    override fun getItemCount(): Int = differ.currentList.size
}