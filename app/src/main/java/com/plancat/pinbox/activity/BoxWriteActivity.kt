package com.plancat.pinbox.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_box_write.*
import kotlinx.android.synthetic.main.pin_header_ui.view.*
import com.plancatlog.pinbox.R
import kotlinx.android.synthetic.main.pin_header_ui.*

class BoxWriteActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box_write)

        initPinHeader()
    }

    fun initPinHeader() {
        // HOME
        pin_header_left.setOnClickListener {
            finish()
        }
        pin_header_right.setOnClickListener {
            android.widget.Toast.makeText(applicationContext, "완료", android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}
