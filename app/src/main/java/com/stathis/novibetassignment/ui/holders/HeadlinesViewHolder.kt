package com.stathis.novibetassignment.ui.holders

import android.view.View
import com.stathis.novibetassignment.abstraction.AbstractViewHolder
import com.stathis.novibetassignment.abstraction.LocalModel
import com.stathis.novibetassignment.callbacks.ItemClickListener
import com.stathis.novibetassignment.models.BetViewItem
import kotlinx.android.synthetic.main.holder_headlines_item.view.*

class HeadlinesViewHolder(itemView : View, callback : ItemClickListener) : AbstractViewHolder(itemView,callback) {

    override fun present(data: LocalModel) {
        when(data){
            is BetViewItem -> {
                when(data.competitor1Caption.isNullOrEmpty() && data.competitor2Caption.isNullOrEmpty()){
                    true -> {
                        itemView.headline_competitor1Caption.text = data.title
                        itemView.headline_competitor2Caption.text = data.text
                    }
                    false -> {
                        itemView.headline_competitor1Caption.text = data.competitor1Caption
                        itemView.headline_competitor2Caption.text = data.competitor2Caption
                        itemView.headline_start_time.text = data.startTime
                    }
                }
            }
        }
    }
}