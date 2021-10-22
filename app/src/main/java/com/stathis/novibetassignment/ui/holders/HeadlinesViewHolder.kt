package com.stathis.novibetassignment.ui.holders

import android.view.View
import com.stathis.novibetassignment.abstraction.AbstractViewHolder
import com.stathis.novibetassignment.abstraction.LocalModel
import com.stathis.novibetassignment.callbacks.ItemClickListener

class HeadlinesViewHolder(itemView : View, callback : ItemClickListener) : AbstractViewHolder(itemView,callback) {

    override fun present(data: LocalModel) {
        when(data){
            //Handle cases
        }
    }
}