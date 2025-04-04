package com.example.soundboard.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.soundboard.data.SoundModel
import com.example.soundboard.databinding.ItemSoundButtonBinding

/**
 * RecyclerView adapter for the sound button grid
 */
class SoundButtonAdapter(
    private val sounds: List<SoundModel>,
    private val onSoundButtonClick: (SoundModel) -> Unit
) : RecyclerView.Adapter<SoundButtonAdapter.SoundButtonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundButtonViewHolder {
        val binding = ItemSoundButtonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SoundButtonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SoundButtonViewHolder, position: Int) {
        holder.bind(sounds[position])
    }

    override fun getItemCount(): Int = sounds.size

    inner class SoundButtonViewHolder(
        private val binding: ItemSoundButtonBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.buttonSound.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onSoundButtonClick(sounds[position])
                }
            }
        }

        fun bind(sound: SoundModel) {
            binding.buttonSound.apply {
                text = sound.name
                backgroundTintList = ContextCompat.getColorStateList(
                    itemView.context,
                    sound.colorResourceId
                )
                contentDescription = "Play ${sound.name} sound"
            }
        }
    }
} 