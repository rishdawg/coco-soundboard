package com.example.soundboard.data

/**
 * Data class representing a sound in the sound board
 */
data class SoundModel(
    val id: Int,
    val name: String,
    val resourceId: Int,
    val colorResourceId: Int,
    var volume: Float = 1.0f,
    var category: String = ""
) 