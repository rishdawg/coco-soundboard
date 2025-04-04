package com.example.soundboard.data

import com.example.soundboard.R

/**
 * Repository class for managing sound data and resources
 */
class SoundRepository {
    
    /**
     * Get all available sounds for the sound board
     */
    fun getSounds(): List<SoundModel> {
        // Note: In a real app, these would be actual sound resources in res/raw
        // For now, we're using placeholder IDs
        return listOf(
            SoundModel(1, "Drum", R.raw.placeholder, R.color.sound_button_1),
            SoundModel(2, "Cymbal", R.raw.placeholder, R.color.sound_button_2),
            SoundModel(3, "Clap", R.raw.placeholder, R.color.sound_button_3),
            SoundModel(4, "Snap", R.raw.placeholder, R.color.sound_button_4),
            SoundModel(5, "Bass", R.raw.placeholder, R.color.sound_button_5),
            SoundModel(6, "Beep", R.raw.placeholder, R.color.sound_button_6),
            SoundModel(7, "Horn", R.raw.placeholder, R.color.sound_button_7),
            SoundModel(8, "Bell", R.raw.placeholder, R.color.sound_button_8),
            SoundModel(9, "Guitar", R.raw.placeholder, R.color.sound_button_9),
            SoundModel(10, "Piano", R.raw.placeholder, R.color.sound_button_10),
            SoundModel(11, "Synth", R.raw.placeholder, R.color.sound_button_11),
            SoundModel(12, "Whistle", R.raw.placeholder, R.color.sound_button_12),
            SoundModel(13, "Scratch", R.raw.placeholder, R.color.sound_button_13),
            SoundModel(14, "Laugh", R.raw.placeholder, R.color.sound_button_14),
            SoundModel(15, "Applause", R.raw.placeholder, R.color.sound_button_15),
            SoundModel(16, "Duck", R.raw.placeholder, R.color.sound_button_16)
        )
    }
} 