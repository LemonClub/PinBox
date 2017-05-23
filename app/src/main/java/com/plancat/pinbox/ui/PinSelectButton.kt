package com.plancat.pinbox.ui

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.pin_select_button.view.*
import com.plancatlog.pinbox.R

/**
 * Created by slopcat99 on 2017-05-14.
 * Pin Select Button Class
 */

open class PinSelectButton : android.widget.LinearLayout {
    lateinit var pinLine: android.view.View
    lateinit var pinText: android.widget.TextView

    var pinTextColorNormal: Int
    var pinTextColorSelect: Int

    init {
        pinTextColorSelect = 0
        pinTextColorNormal = 0
    }

    constructor(context: android.content.Context) : super(context) {
        initView()
    }

    constructor(context: android.content.Context, attrs: android.util.AttributeSet) : super(context, attrs) {
        initView()
        getAttrs(attrs)
    }

    constructor(context: android.content.Context, attrs: android.util.AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView()
        getAttrs(attrs, defStyle)
    }

    fun initView() {
        val inflaterService = android.content.Context.LAYOUT_INFLATER_SERVICE
        val li = context.getSystemService(inflaterService) as android.view.LayoutInflater
        val v = li.inflate(com.plancatlog.pinbox.R.layout.pin_select_button, this, false)
        this.addView(v)
        pinLine = pin_select_line
        pinText = pin_select_text
    }

    fun getAttrs(attrs: android.util.AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, com.plancatlog.pinbox.R.styleable.PinSelectButton)
        setTypeArray(typedArray)
    }

    fun getAttrs(attrs: android.util.AttributeSet, defStyle: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, com.plancatlog.pinbox.R.styleable.PinSelectButton, defStyle, 0)
        setTypeArray(typedArray)
    }

    fun setTypeArray(typedArray: android.content.res.TypedArray) {
        val text = typedArray.getString(com.plancatlog.pinbox.R.styleable.PinSelectButton_text)
        val active = typedArray.getBoolean(com.plancatlog.pinbox.R.styleable.PinSelectButton_active, false)

        pinTextColorNormal = typedArray.getColor(com.plancatlog.pinbox.R.styleable.PinSelectButton_text_color_normal, 0)
        pinTextColorSelect = typedArray.getColor(com.plancatlog.pinbox.R.styleable.PinSelectButton_text_color_select, 0)

        setText(text)
        setActive(active)

        typedArray.recycle()
    }

    fun setText(text: String) {
        pinText.text = text
    }

    fun setActive(active: Boolean) {
        if (active) {
            pinText.setTextColor(pinTextColorSelect!!)
            pinLine.visibility = android.view.View.VISIBLE
        } else {
            pinText.setTextColor(pinTextColorNormal!!)
            pinLine.visibility = android.view.View.INVISIBLE
        }
    }
}