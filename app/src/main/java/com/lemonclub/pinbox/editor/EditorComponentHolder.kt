package com.lemonclub.pinbox.editor

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lemonclub.pinbox.R
import kotlinx.android.synthetic.main.editor_component_item.view.*

class EditorComponentHolder : RecyclerView.ViewHolder {
    var componentType: ComponentType? = null
    var componet: Any? = null

    constructor(parent: ViewGroup) : super(LayoutInflater.from(parent.context).inflate(R.layout.editor_component_item, parent, false))

    fun init(componentType: ComponentType) {
        this.componentType = componentType
        itemView.component_empty_root.visibility = View.GONE
        itemView.component_text.visibility = View.GONE
        when (componentType) {
            ComponentType.EMPTY -> {
                itemView.component_empty_root.visibility = View.VISIBLE
                componet = itemView.component_empty_root
            }
            ComponentType.TEXT -> {
                itemView.component_text.visibility = View.VISIBLE
                componet = itemView.component_text
            }
        }
    }

    fun setOnClickEditorTextComponent(listener: View.OnClickListener) = itemView.component_empty_text.setOnClickListener(listener)
    fun setOnClickEditorImageComponent(listener: View.OnClickListener) = itemView.component_empty_image.setOnClickListener(listener)
}