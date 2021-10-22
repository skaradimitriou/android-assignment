package com.stathis.novibetassignment.models

data class LiveDataX(
    val adjustTimeMillis: Int?,
    val awayPoints: Int?,
    val duration: String?,
    val durationSeconds: Double?,
    val elapsed: String?,
    val elapsedSeconds: Double?,
    val homePoints: Int?,
    val homePossession: Boolean?,
    val isInPlay: Boolean?,
    val isInPlayPaused: Boolean?,
    val isInterrupted: Boolean?,
    val isLive: Boolean?,
    val liveStreamingCountries: String?,
    val phaseCaption: String?,
    val phaseCaptionLong: String?,
    val phaseSysname: String?,
    val quarterScores: List<QuarterScore>?,
    val referenceTime: String?,
    val referenceTimeUnix: Int?,
    val remaining: String?,
    val remainingSeconds: Double?,
    val sportradarMatchId: Int?,
    val supportsAchievements: Boolean?,
    val supportsActions: Boolean?,
    val timeToNextPhase: Any?,
    val timeToNextPhaseSeconds: Any?,
    val timeline: Any?
)