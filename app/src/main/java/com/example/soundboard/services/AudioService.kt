package com.example.soundboard.services

import android.content.Context
import android.content.res.Resources
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import com.example.soundboard.data.SoundModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Service for handling audio playback using SoundPool
 */
class AudioService(private val context: Context) {

    private val soundPool: SoundPool by lazy {
        val attributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        
        SoundPool.Builder()
            .setMaxStreams(10) // Allow up to 10 concurrent sounds
            .setAudioAttributes(attributes)
            .build()
    }
    
    private val soundMap = mutableMapOf<Int, Int>() // Maps sound IDs to loaded sound IDs
    
    /**
     * Load a sound into the SoundPool
     */
    suspend fun loadSound(sound: SoundModel): Int = withContext(Dispatchers.IO) {
        try {
            val soundId = soundPool.load(context, sound.resourceId, 1)
            soundMap[sound.id] = soundId
            soundId
        } catch (e: Resources.NotFoundException) {
            Log.e("AudioService", "Failed to load sound resource: ${sound.resourceId}", e)
            // Return a placeholder ID that won't be used
            -1
        }
    }
    
    /**
     * Preload all sounds in the list
     */
    suspend fun preloadSounds(sounds: List<SoundModel>) = withContext(Dispatchers.IO) {
        sounds.forEach { sound ->
            loadSound(sound)
        }
    }
    
    /**
     * Play a sound
     * @return stream ID for the played sound, or 0 if the sound couldn't be played
     */
    fun playSound(soundId: Int, volume: Float = 1.0f): Int {
        val loadedSoundId = soundMap[soundId] ?: return 0
        // Don't try to play sounds that failed to load
        if (loadedSoundId < 0) return 0
        return soundPool.play(loadedSoundId, volume, volume, 1, 0, 1.0f)
    }
    
    /**
     * Stop a currently playing sound
     */
    fun stopSound(streamId: Int) {
        soundPool.stop(streamId)
    }
    
    /**
     * Release resources when no longer needed
     */
    fun release() {
        soundPool.release()
        soundMap.clear()
    }
} 