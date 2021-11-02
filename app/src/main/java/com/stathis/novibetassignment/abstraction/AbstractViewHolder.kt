package com.stathis.novibetassignment.abstraction

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.stathis.novibetassignment.callbacks.ItemClickListener

abstract class AbstractViewHolder(itemView : View, callback : ItemClickListener ?= null) : RecyclerView.ViewHolder(itemView) {

    /*
     * This viewHolder has a click listener for the whole view item.
     * It also binds the data to the itemView.tag so we know what kind of model it is
     * and thus we can reduce the boilerplate code in our app
     *
     */

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