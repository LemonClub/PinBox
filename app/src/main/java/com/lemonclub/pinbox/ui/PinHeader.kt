package com.lemonclub.pinbox.ui


import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.lemonclub.pinbox.R
import com.lemonclub.pinbox.R.id.*
import kotlinx.android.synthetic.main.pin_header_ui.view.*

open class PinHeader : LinearLayout {
    var pinLeftText: TextView? = null
    var pinRightText: TextView? = null
    var pinLeftTextColor: Int? = null
    var pinRightTextColor: Int? = null

    var pinLine: View? = null

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
        val v = li.inflate(R.layout.pin_header_ui, this, false)
        this.addView(v)
        pinRightText = pin_header_right
        pinLeftText = pin_header_left
        pinLine = pin_header_line
    }

    fun getAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PinHeader)
        setTypeArray(typedArray)
    }

    fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PinHeader, defStyle, 0)
        setTypeArray(typedArray)
    }

    fun setTypeArray(typedArray: TypedArray) {
        val leftText = typedArray.getString(R.styleable.PinHeader_pin_left_text)
        val leftActivity = typedArray.getBoolean(R.styleable.PinHeader_pin_left_active, false)
        val rightText = typedArray.getString(R.styleable.PinHeader_pin_right_text)
        val rightActivity = typedArray.getBoolean(R.styleable.PinHeader_pin_left_active, false)

        val isUnderline = typedArray.getBoolean(R.styleable.PinHeader_pin_underline, false)

        pinLeftTextColor = typedArray.getColor(R.styleable.PinHeader_pin_left_color, 0)
        pinRightTextColor = typedArray.getColor(R.styleable.PinHeader_pin_right_color, 0)

        setText(false, leftText)
        setText(true, rightText)

        setActive(false, leftActivity)
        setActive(true, rightActivity)

        setColor(false, pinLeftTextColor!!)
        setColor(true, pinRightTextColor!!)

        setUnderline(isUnderline)

        typedArray.recycle()
    }

    fun setText(isRight: Boolean, text: String) {
        if (!isRight)
            pinLeftText!!.text = text
        else
            pinRightText!!.text = text
    }

    fun setActive(isRight: Boolean, active: Boolean) {
        if (!isRight) {
            if (active)
                pinLeftText!!.visibility = View.VISIBLE
            else
                pinLeftText!!.visibility = View.INVISIBLE
        } else {
            if (active)
                pinRightText!!.visibility = View.VISIBLE
            else
                pinRightText!!.visibility = View.INVISIBLE
        }
    }

    fun setColor(isRight: Boolean, color: Int) {
        if (!isRight) {
            pinLeftText!!.setTextColor(color)
        } else {
            pinRightText!!.setTextColor(color)
        }
    }

    fun setUnderline(boolean: Boolean) {
        if (boolean)
            pinLine!!.visibility = View.VISIBLE
        else
            pinLine!!.visibility = View.INVISIBLE
    }
}