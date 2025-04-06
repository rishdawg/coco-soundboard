package com.example.soundboard.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.soundboard.databinding.ActivityMainBinding
import com.example.soundboard.utils.HapticFeedbackHelper
import com.example.soundboard.utils.GridSpacingItemDecoration

/**
 * Main activity for the sound board application
 */
class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var soundAdapter: SoundButtonAdapter
    private lateinit var hapticFeedbackHelper: HapticFeedbackHelper
    
    // Configuration settings (could be moved to preferences)
    private val gridColumns = 3
    private val enableHapticFeedback = true
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        hapticFeedbackHelper = HapticFeedbackHelper(this)
        
        setupRecyclerView()
        observeViewModel()
    }
    
    private fun setupRecyclerView() {
        binding.recyclerViewSoundBoard.apply {
            layoutManager = GridLayoutManager(this@MainActivity, gridColumns)
            setHasFixedSize(true)
            addItemDecoration(GridSpacingItemDecoration(gridColumns, 8, true))
            clipToPadding = false
            setPadding(16, 16, 16, 16)
        }
    }
    
    private fun observeViewModel() {
        viewModel.soundList.observe(this) { sounds ->
            soundAdapter = SoundButtonAdapter(sounds) { sound ->
                // Play sound when button is clicked
                viewModel.playSound(sound)
                
                // Provide haptic feedback if enabled
                if (enableHapticFeedback) {
                    hapticFeedbackHelper.vibrateForButtonPress()
                }
            }
            binding.recyclerViewSoundBoard.adapter = soundAdapter
        }
    }
} 