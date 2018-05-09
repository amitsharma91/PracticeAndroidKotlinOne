package com.example.developeramit.newsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.developeramit.newsample.data.ReturnData
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class MainAdapter(val returnedData: ReturnData, val context: Context) : RecyclerView.Adapter<CustomViewHolder>() {


    val videoTitleList = listOf("First Video", "Second Title", "Third Title", "Fourth Title", "Fifth Title", "sixth Title", "Seventh Title")

    override fun getItemCount(): Int {
        return returnedData.videos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val element = layoutInflater.inflate(R.layout.recycler_view_item, parent, false)

        return CustomViewHolder(element)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val videoTitle = returnedData.videos.get(position).name
        val channelName = returnedData.videos.get(position).channel.name

        holder.view.title.text = videoTitle
        holder.view.channelList.text = channelName

        Glide.with(context).load(returnedData.videos.get(position).imageUrl).into(holder.view.videoThumbnail)

        Glide.with(context).load(returnedData.videos.get(position).channel.profileImageUrl).apply(RequestOptions.circleCropTransform()).into(holder.view.imageView2)
    }
}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

}

