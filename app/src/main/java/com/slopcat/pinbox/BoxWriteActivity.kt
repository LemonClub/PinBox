package com.slopcat.pinbox

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_box_write.*
import kotlinx.android.synthetic.main.pin_header_ui.view.*

class BoxWriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box_write)

        initPinHeader()
    }

    fun initPinHeader() {
        // HOME
        pin_header_write.pin_header_left.setOnClickListener {
            finish()
        }
        pin_header_write.pin_header_right.setOnClickListener {
            Toast.makeText(applicationContext, "완료", Toast.LENGTH_SHORT).show()
        }
    }
}
