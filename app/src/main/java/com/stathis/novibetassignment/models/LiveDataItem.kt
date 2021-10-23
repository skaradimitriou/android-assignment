package com.stathis.novibetassignment.models

import com.stathis.novibetassignment.abstraction.LocalModel

data class LiveDataItem(
    val remaining : String,
    val remainingSeconds : Double,
    val homePoints : Int,
    val awayPoints : Int,
    val quarterScores : Int?,
    val homePossession : Boolean,
    val supportsAchievements : Boolean,
    val liveStreamingCountries : String,
    val sportradarMatchId : Int,
    val referenceTime : String,
    val referenceTimeUnix : Int,
    val elapsed : String,
    val elapsedSeconds : Double,
    val duration : String,
    val durationSeconds : Int,
    val timeToNextPhase : String,
    val timeToNextPhaseSeconds :Double?,
    val phaseSysname : String,
    val phaseCaption : String,
    val phaseCaptionLong : String,
    val isLive : Boolean,
    val isInPlay : Boolean,
    val isInPlayPaused : Boolean,
    val isInterrupted : Boolean,
    val supportsActions : Boolean,
    val adjustTimeMillis : Int
) : LocalModel{
    override fun equalsContent(data: LocalModel): Boolean = false
}
