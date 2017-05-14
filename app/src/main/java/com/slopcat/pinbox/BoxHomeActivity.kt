package com.slopcat.pinbox

import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home_box.*

class BoxHomeActivity : AppCompatActivity() {

    val pinboxSelectors = ArrayList<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_box)

        pinboxSelectors.add(pin_boxs)
        pinboxSelectors.add(pin_pins)
        pinboxSelectors.add(pin_nows)

        // Pin Navigation
        // User
        pin_write.setOnClickListener {
            hideNavigation()
        }

        pin_boxs.setOnClickListener {
            hideNavigation()
            activeSelector(0)
        }

        // Pin Box
        pin_pins.setOnClickListener {
            hideNavigation()
            activeSelector(1)
        }
        pin_nows.setOnClickListener {
            hideNavigation()
            activeSelector(2)
        }

        // PIN OPTION
        pin_option.setOnClickListener {
            hideNavigation()
        }
    }

    fun activeSelector(n: Int) {
        for (item in pinboxSelectors)
            (item as PinSelectButton).setActive(false)
        (pinboxSelectors[n] as PinSelectButton).setActive(true)
    }

    fun hideNavigation() {
        this.drawer_layout.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (this.drawer_layout.isDrawerOpen(GravityCompat.START))
            hideNavigation()
        else
            super.onBackPressed()
    }
}