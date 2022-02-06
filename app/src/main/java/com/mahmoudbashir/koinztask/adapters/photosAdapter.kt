package com.mahmoudbashir.koinztask.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahmoudbashir.koinztask.R
import com.mahmoudbashir.koinztask.model.Photo
import com.mahmoudbashir.koinztask.utils.Constants

class photosAdapter(val context:Context,val interfacrIClicked: IClicked): RecyclerView.Adapter<photosAdapter.ViewHolder>() {


    private val differCallback = object : DiffUtil.ItemCallback<Photo>(){
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgV = itemView.findViewById<ImageView>(R.id.imgV)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return if (viewType == Constants.AD_TYPE)
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adbanner_layout,parent,false))
        else ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_item_photos,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photoItem =differ.currentList[position]


        if (getItemViewType(position) == Constants.CONTENT_TYPE){
            val url = "https://farm${photoItem.farm}.static.flickr.com/${photoItem.server}/${photoItem.id}_${photoItem.secret}.jpg"
            Glide.with(context).load(url).placeholder(R.drawable.ic_launcher_background).into(holder.imgV)

            holder.imgV.setOnClickListener {
                interfacrIClicked.onClickedItem(url)
            }
        }


    }

    override fun getItemCount(): Int = differ.currentList.size

    interface IClicked{
        fun onClickedItem(photUrl:String)
    }


    override fun getItemViewType(position: Int): Int {

        if (position != 0 && position % 6 == 0)
            return Constants.AD_TYPE
        return Constants.CONTENT_TYPE
    }
}