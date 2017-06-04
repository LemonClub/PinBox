package com.lemonclub.pinbox.data

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.lemonclub.pinbox.R
import kotlinx.android.synthetic.main.pin_feed_post.view.*

/**
 * Created by slopcat99 on 2017-06-04.
 */

class PinPostHolder : RecyclerView.ViewHolder {
    val profileName: TextView
    val postMessage: TextView

    constructor(parent: ViewGroup) : super(LayoutInflater.from(parent.context).inflate(R.layout.pin_feed_post, parent, false)) {
        profileName = itemView.pin_post_user_profile_name
        postMessage = itemView.pin_post_message
    }
}