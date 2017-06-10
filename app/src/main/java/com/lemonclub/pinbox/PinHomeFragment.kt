package com.lemonclub.pinbox

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lemonclub.pinbox.data.PinPostAdapter
import com.lemonclub.pinbox.data.PinPostData
import kotlinx.android.synthetic.main.fragment_home.view.*

class PinHomeFragment : Fragment() {
    val pinPostAdapter: PinPostAdapter

    lateinit var pinPostLayoutManager: LinearLayoutManager

    init {
        pinPostAdapter = PinPostAdapter()
        pinPostAdapter.feedDatas.add(PinPostData("plancat", "Hello Hello Hello Hello\nMy name is Junseo Youn\nKorea Game Science High School"))
        pinPostAdapter.feedDatas.add(PinPostData("plancat", "Hello Hello Hello Hello\nMy name is Junseo Youn\nKorea Game Science High School"))
        pinPostAdapter.feedDatas.add(PinPostData("proal", "Hello Hello Hello Hello\nMy name is Junseo Youn\nKorea Game Science High School"))
        pinPostAdapter.feedDatas.add(PinPostData("cid", "Hello Hello Hello Hello\nMy name is Junseo Youn\nKorea Game Science High School"))
        pinPostAdapter.feedDatas.add(PinPostData("plancat", "Hello Hello Hello Hello\nMy name is Junseo Youn\nKorea Game Science High School"))
        pinPostAdapter.feedDatas.add(PinPostData("plancat", "Hello Hello Hello Hello\nMy name is Junseo Youn\nKorea Game Science High School"))
        pinPostAdapter.feedDatas.add(PinPostData("proal", "Hello Hello Hello Hello\nMy name is Junseo Youn\nKorea Game Science High School"))
        pinPostAdapter.feedDatas.add(PinPostData("cid", "Hello Hello Hello Hello\nMy name is Junseo Youn\nKorea Game Science High School"))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.fragment_home, container, false)

        pinPostLayoutManager = LinearLayoutManager(inflater.context)
        rootView.pin_post_feed_list.layoutManager = pinPostLayoutManager
        rootView.pin_post_feed_list.adapter = pinPostAdapter
        return rootView
    }
}