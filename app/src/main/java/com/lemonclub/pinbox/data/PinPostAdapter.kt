package com.lemonclub.pinbox.data

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.lemonclub.pinbox.R
import kotlinx.android.synthetic.main.pin_feed_post.view.*

class PinPostAdapter : RecyclerView.Adapter<PinPostHolder>() {
    val feedDatas = ArrayList<PinPostData>()

    override fun onBindViewHolder(holder: PinPostHolder?, position: Int) {
        val feedHolder = holder!!
        val feedData = feedDatas.get(position)

        feedHolder.profileName.text = feedData.profileName
        feedHolder.postMessage.text = feedData.postMessage
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PinPostHolder = PinPostHolder(parent!!)
    override fun getItemCount(): Int = feedDatas.count()
}