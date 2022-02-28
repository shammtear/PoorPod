package com.arthurph.poor.pod.models

import com.arthurph.poor.pod.models.music.AlbumData

data class MusicData(
    var name: String,
    var artist: String = "Unknown",
    var duration: Double,
    var album: AlbumData,
    var addedIn: String,
    var path: String,
    var quality: String?,
    var playedTimes: Int = 0
)
