package com.kainzengaming.sport.sports.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kainzengaming.sport.R
import com.kainzengaming.sport.databinding.ViewholderSportsEventBinding
import com.kainzengaming.sport.sports.presentation.model.EventDataUi

class EventViewHolder private constructor(
    private val binding: ViewholderSportsEventBinding,
    private val onEventClickListener: (EventDataUi) -> Unit
) : ViewHolder(binding.root) {

    fun bind(data: EventDataUi) {
        with(binding) {
            this.root.setOnClickListener {
                onEventClickListener(data)
            }
            competitor1TextView.text = data.name.firstCompetitor()
            competitor2TextView.text = data.name.secondCompetitor()
            countdownTimer.setTimer(data.startTime)
            updateFavoriteImage(data)
        }
    }

    private fun ViewholderSportsEventBinding.updateFavoriteImage(data: EventDataUi) {
        eventFavoriteImageView.setImageResource(
            if (data.isFavorite)
                R.drawable.ic_favorite_event_selected
            else
                R.drawable.ic_favorite_event_unselected
        )
    }

    companion object {
        fun getViewHolder(
            parent: ViewGroup,
            onEventClickListener: (EventDataUi) -> Unit
        ) =
            EventViewHolder(
                ViewholderSportsEventBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onEventClickListener
            )
    }

    private fun String.firstCompetitor() = this.split('-').first().trim()
    private fun String.secondCompetitor() = this.split('-').last().trim()
}