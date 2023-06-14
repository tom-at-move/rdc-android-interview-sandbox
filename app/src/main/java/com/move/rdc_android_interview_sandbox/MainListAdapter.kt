package com.move.rdc_android_interview_sandbox

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.move.rdc_android_interview_sandbox.models.Property

class MainListAdapter(private val context: Context) : RecyclerView.Adapter<MainListAdapter.ListItemHolder>() {
    private var properties: List<Property> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item, parent, false)
        return ListItemHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return properties.size
    }

    fun setListItems(listItems: List<Property>) {
        this.properties = listItems
    }

    class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}