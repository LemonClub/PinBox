package com.lemonclub.pinbox.editor

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class EditorComponentAdapter : RecyclerView.Adapter<EditorComponentHolder>() {
    val components = ArrayList<EditorComponentData>()
    val componentsHolders = ArrayList<EditorComponentHolder>()

    init {
        components.add(EditorComponentData(ComponentType.EMPTY))
    }

    override fun onBindViewHolder(holder: EditorComponentHolder, position: Int) {
        holder.init(components[position].componentType)
        holder.setOnClickEditorTextComponent(View.OnClickListener {
            holder.itemView.isActivated = true
            components[position].componentType = ComponentType.TEXT
            notifyItemChanged(position)
            addNewEmptyItem(position)
        })

        holder.setOnClickEditorImageComponent(View.OnClickListener {
            holder.itemView.isActivated = true
            components[position].componentType = ComponentType.IMAGE
            notifyItemChanged(position)
            addNewEmptyItem(position)
        })
    }

    override fun getItemId(position: Int): Long = position.toLong()
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EditorComponentHolder {
        val componentHolder = EditorComponentHolder(parent!!)
        componentsHolders.add(componentHolder)
        return componentHolder
    }

    override fun getItemCount(): Int = components.size
    fun addNewEmptyItem(position: Int) {
        components.add(EditorComponentData(ComponentType.EMPTY))
        notifyItemInserted(position)
    }
}