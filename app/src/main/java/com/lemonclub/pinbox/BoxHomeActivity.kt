package com.lemonclub.pinbox

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import com.lemonclub.pinbox.ui.PinSelectButton
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.pin_header_ui.*

class BoxHomeActivity : AppCompatActivity() {
    val pinboxSelectors = ArrayList<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        pinboxSelectors.add(pin_boxs)
        pinboxSelectors.add(pin_home)
        pinboxSelectors.add(pin_nows)

        initPinBox()
        initPinHeader()

        pin_home.callOnClick()
    }

    // Navigation 버튼 초기화
    fun initPinBox() {
        pin_write.setOnClickListener {
            pinBoxHide()
        }
        pin_boxs.setOnClickListener {
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