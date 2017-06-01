package com.lemonclub.pinbox

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.support.v4.view.GravityCompat
import com.lemonclub.pinbox.data.PinPostAdapter
import com.lemonclub.pinbox.data.PinPostData
import com.lemonclub.pinbox.ui.PinSelectButton
import kotlinx.android.synthetic.main.activity_box_home.*
import kotlinx.android.synthetic.main.pin_header_ui.*

class BoxHomeActivity : Activity() {
    val pinboxSelectors = ArrayList<Any>()
    lateinit var pinPostAdapter: PinPostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box_home)

        pinboxSelectors.add(pin_drawer)
        pinboxSelectors.add(pin_home)
        pinboxSelectors.add(pin_nows)

        initPinBox()
        initPinHeader()

        pinPostAdapter = PinPostAdapter(layoutInflater)
        pinPostAdapter.pinposts.add(PinPostData("plancat", "A", "아아ㅏ아ㅏㅏ아아아ㅏ아ㅣ"))
        pinPostAdapter.pinposts.add(PinPostData("plancat", "A", "와아아ㅏㅇㅇ오ㅗ아오아아"))
        pinPostAdapter.pinposts.add(PinPostData("proal", "A", "라라라ㅏ라라라ㅏㅇ아"))
        pinPostAdapter.pinposts.add(PinPostData("cid", "A", "히히히ㅣㅎ니히ㅣ니히ㅣ히히ㅣㅎ"))

        pin_post_feed_list.adapter = pinPostAdapter

        pin_home.callOnClick()
    }

    // Navigation 버튼 초기화
    fun initPinBox() {
        pin_write.setOnClickListener {
            pinBoxHide()
        }
        pin_drawer.setOnClickListener {
            pinBoxHide()
            pinBoxSelector(0)
        }
        pin_home.setOnClickListener {
            pinBoxHide()
            pinBoxSelector(1)

            pin_header_home.visibility = View.VISIBLE
        }
        pin_nows.setOnClickListener {
            pinBoxHide()
            pinBoxSelector(2)
        }
        pin_option.setOnClickListener {
            pinBoxHide()
        }
    }

    fun initPinHeader() {
        // HOME
        pin_header_left.setOnClickListener {
            pinHeaderMenu()
        }

        pin_header_right.setOnClickListener {
            pinHeaderSearch()
        }
    }

    fun pinHeaderMenu() {
        pinBoxShow()
    }

    fun pinHeaderSearch() {

    }

    fun pinBoxSelector(n: Int) {
        for (item in pinboxSelectors)
            (item as PinSelectButton).setActive(false)
        (pinboxSelectors[n] as PinSelectButton).setActive(true)
    }

    fun pinBoxHide() {
        drawer_layout.closeDrawer(GravityCompat.START)
    }

    fun pinBoxShow() {
        drawer_layout.openDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START))
            pinBoxHide()
        else
            super.onBackPressed()
    }
}