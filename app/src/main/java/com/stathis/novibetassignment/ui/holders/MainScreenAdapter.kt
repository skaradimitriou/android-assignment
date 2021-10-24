package com.stathis.novibetassignment.ui.holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.AbstractViewHolder
import com.stathis.novibetassignment.abstraction.DiffUtilClass
import com.stathis.novibetassignment.abstraction.LocalModel
import com.stathis.novibetassignment.callbacks.ItemClickListener
import com.stathis.novibetassignment.models.BetViewItem
import com.stathis.novibetassignment.models.EventsItem

class MainScreenAdapter(val callback : ItemClickListener) : ListAdapter<LocalModel, AbstractViewHolder>(DiffUtilClass<LocalModel>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType,parent,false)
        return when(viewType){
            R.layout.holder_headlines_item -> HeadlinesViewHolder(view,callback)
            R.layout.hodler_games_item -> GamesViewHolder(view,callback)
            else -> EmptyHolder(view)
        }
    }

    override fun onBindViewHolder(holder: AbstractViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)){
        is BetViewItem -> R.layout.holder_headlines_item
        is EventsItem -> R.layout.hodler_games_item
        else -> R.layout.holder_empty_item
    }
}