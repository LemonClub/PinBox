package com.lemonclub.pinbox.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.lemonclub.pinbox.R
import kotlinx.android.synthetic.main.pin_feed_post.view.*

class PinPostAdapter(val layoutInflater: LayoutInflater) : BaseAdapter() {
    var pinposts = ArrayList<PinPostData>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null)
            view = layoutInflater.inflate(R.layout.pin_feed_post, parent, false)
        val feedItem = getItem(position) as PinPostData

        view!!.pin_post_user_profile_name.text = feedItem.profileNickname
        view.pin_post_timestamp.text = feedItem.postTimeStamp
        view.pin_post_message.text = feedItem.postMessage

        return view
    }

    override fun getItem(position: Int): Any = pinposts.get(position)
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getCount(): Int = pinposts.count()
}