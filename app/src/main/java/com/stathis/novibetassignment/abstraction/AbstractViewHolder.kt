package com.stathis.novibetassignment.abstraction

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.novibetassignment.callbacks.ItemClickListener

abstract class AbstractViewHolder(itemView : View, callback : ItemClickListener ?= null) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            callback?.onItemTap(it)
        }
    }

    fun bindData(data : LocalModel){
        itemView.tag = data
        present(data)
    }

    abstract fun present(data : LocalModel)
}