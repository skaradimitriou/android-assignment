package com.stathis.novibetassignment.ui.holders

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.AbstractViewHolder
import com.stathis.novibetassignment.abstraction.LocalModel
import com.stathis.novibetassignment.callbacks.ItemClickListener
import com.stathis.novibetassignment.models.EventsItem
import kotlinx.android.synthetic.main.hodler_games_item.view.*
import java.time.LocalDateTime
import java.time.LocalTime

class GamesViewHolder(itemView: View, callback: ItemClickListener) : AbstractViewHolder(itemView, callback) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun present(data: LocalModel) {
        when (data) {
            is EventsItem -> {
                itemView.game_competitor1.text = data.additionalCaptions.competitor1
                itemView.game_competitor2.text = data.additionalCaptions.competitor2

                when (data.liveData.isInPlay) {
                    true -> {
                        val time = data.liveData.elapsed
                        val cleanTime = LocalTime.parse(time)
                        itemView.game_elapsed_time.text = "${cleanTime.minute}:${cleanTime.second}"
                    } //negative time
                    false -> {
                        itemView.game_elapsed_time.text = itemView.resources.getString(R.string.game_ended)
                    }
                }
            }
        }
    }
}