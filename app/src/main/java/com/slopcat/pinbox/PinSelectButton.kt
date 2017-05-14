package com.slopcat.pinbox

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.pin_select_button.view.*

/**
 * Created by slopcat99 on 2017-05-14.
 * Pin Select Button Class
 */

open class PinSelectButton : LinearLayout {
    var pinLine: View? = null
    var pinText: TextView? = null

    var pinTextColorNormal: Int? = null
    var pinTextColorSelect: Int? = null

    constructor(context: Context) : super(context) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView()
        getAttrs(attrs, defStyle)
    }

    fun initView() {
        val inflaterService = Context.LAYOUT_INFLATER_SERVICE
        val li = context.getSystemService(inflaterService) as LayoutInflater
        val v = li.inflate(R.layout.pin_select_button, this, false)
        this.addView(v)
        pinLine = v.pin_select_line
        pinText = v.pin_select_text
    }

    fun getAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PinSelectButton)
        setTypeArray(typedArray)
    }

    fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PinSelectButton, defStyle, 0)
        setTypeArray(typedArray)
    }

    fun setTypeArray(typedArray: TypedArray) {
        val text = typedArray.getString(R.styleable.PinSelectButton_text)
        val active = typedArray.getBoolean(R.styleable.PinSelectButton_active, false)

        pinTextColorNormal = typedArray.getColor(R.styleable.PinSelectButton_text_color_normal, 0)
        pinTextColorSelect = typedArray.getColor(R.styleable.PinSelectButton_text_color_select, 0)

        setText(text)
        setActive(active)

        typedArray.recycle()
    }

    fun setText(text: String) {
        pinText!!.text = text
    }

    fun setActive(active: Boolean) {
        if (active) {
            pinText!!.setTextColor(pinTextColorSelect!!)
            pinLine!!.visibility = View.VISIBLE
        } else {
            pinText!!.setTextColor(pinTextColorNormal!!)
            pinLine!!.visibility = View.INVISIBLE
        }
    }
}