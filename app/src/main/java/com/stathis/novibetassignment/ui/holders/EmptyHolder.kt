package com.stathis.novibetassignment.ui.holders

import android.view.View
import com.stathis.novibetassignment.abstraction.AbstractViewHolder
import com.stathis.novibetassignment.abstraction.LocalModel

class EmptyHolder(itemView : View) : AbstractViewHolder(itemView) {
    override fun present(data: LocalModel) {}
}