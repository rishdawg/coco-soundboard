package com.example.soundboard.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.soundboard.data.SoundModel
import com.example.soundboard.data.SoundRepository
import com.example.soundboard.services.AudioService
import kotlinx.coroutines.launch

/**
 * ViewModel for the main sound board screen
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = SoundRepository()
    private val audioService = AudioService(application)
    
    private val _soundList = MutableLiveData<List<SoundModel>>()
    val soundList: LiveData<List<SoundModel>> = _soundList
    
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    
    init {
        loadSounds()
    }
    
    /**
     * Load the list of sounds and preload them into the SoundPool
     */
    private fun loadSounds() {
        viewModelScope.launch {
            _isLoading.value = true
            val sounds = repository.getSounds()
            _soundList.value = sounds
            
            // Preload sounds into SoundPool
            audioService.preloadSounds(sounds)
            _isLoading.value = false
        }
    }
    
    /**
     * Play a sound when a button is pressed
     */
    fun playSound(sound: SoundModel) {
        audioService.playSound(sound.id, sound.volume)
    }
    
    /**
     * Clean up resources when ViewModel is cleared
     */
    override fun onCleared() {
        super.onCleared()
        audioService.release()
    }
} 