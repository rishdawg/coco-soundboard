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
        // For now, we're using the cat_meow sound for all buttons
        return listOf(
            SoundModel(1, "Meow", R.raw.cat_meow, R.color.sound_button_1),
            SoundModel(2, "Cymbal", R.raw.cat_meow, R.color.sound_button_2),
            SoundModel(3, "Clap", R.raw.cat_meow, R.color.sound_button_3),
            SoundModel(4, "Snap", R.raw.cat_meow, R.color.sound_button_4),
            SoundModel(5, "Bass", R.raw.cat_meow, R.color.sound_button_5),
            SoundModel(6, "Beep", R.raw.cat_meow, R.color.sound_button_6),
            SoundModel(7, "Horn", R.raw.cat_meow, R.color.sound_button_7),
            SoundModel(8, "Bell", R.raw.cat_meow, R.color.sound_button_8),
            SoundModel(9, "Guitar", R.raw.cat_meow, R.color.sound_button_9),
            SoundModel(10, "Piano", R.raw.cat_meow, R.color.sound_button_10),
            SoundModel(11, "Synth", R.raw.cat_meow, R.color.sound_button_11),
            SoundModel(12, "Whistle", R.raw.cat_meow, R.color.sound_button_12),
            SoundModel(13, "Scratch", R.raw.cat_meow, R.color.sound_button_13),
            SoundModel(14, "Laugh", R.raw.cat_meow, R.color.sound_button_14),
            SoundModel(15, "Applause", R.raw.cat_meow, R.color.sound_button_15),
            SoundModel(16, "Duck", R.raw.cat_meow, R.color.sound_button_16)
        )
    }
} 