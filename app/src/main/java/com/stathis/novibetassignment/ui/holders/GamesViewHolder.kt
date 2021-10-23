package com.stathis.novibetassignment.ui.holders

import android.os.Build
import android.os.Handler
import android.view.View
import androidx.annotation.RequiresApi
import com.stathis.novibetassignment.R
import com.stathis.novibetassignment.abstraction.AbstractViewHolder
import com.stathis.novibetassignment.abstraction.LocalModel
import com.stathis.novibetassignment.callbacks.ItemClickListener
import com.stathis.novibetassignment.models.EventsItem
import kotlinx.android.synthetic.main.hodler_games_item.view.*
import java.time.LocalTime
import java.util.*

class GamesViewHolder(itemView: View, callback: ItemClickListener) :
    AbstractViewHolder(itemView, callback) {

    var handler = Handler()
    var runnable: Runnable? = null
    var delay = 1000L
    var counter = 0
    private lateinit var calendar: Calendar

    @RequiresApi(Build.VERSION_CODES.O)
    override fun present(data: LocalModel) {
        when (data) {
            is EventsItem -> {
                itemView.game_competitor1.text = data.additionalCaptions.competitor1
                itemView.game_competitor2.text = data.additionalCaptions.competitor2

                when (data.liveData.isInPlay) {
                    true -> {
                        var cleanTime = LocalTime.parse(data.liveData.elapsed)

                        calendar = Calendar.getInstance().also {
                            it.set(Calendar.HOUR, cleanTime.hour)
                            it.set(Calendar.MINUTE, cleanTime.minute)
                            it.set(Calendar.SECOND, cleanTime.second)
                        }

                        itemView.game_elapsed_time.text = "${cleanTime.minute}:${cleanTime.second}"
                    }
                }


                handler.postDelayed(Runnable {
                    handler.postDelayed(runnable!!, delay)

                    counter++

                    when (data.liveData.isInPlay) {
                        true -> {
                            calendar.add(Calendar.SECOND, 1)

                            var minutes = calendar.time.minutes
                            var second = calendar.time.seconds

                            val formattedSeconds = String.format("%02d", second)

                            itemView.game_elapsed_time.text = "$minutes:$formattedSeconds"
                        }
                        false -> {
                            itemView.game_elapsed_time.text =
                                itemView.resources.getString(R.string.game_ended)
                        }
                    }

                }.also { runnable = it }, delay)
            }
        }
    }

}