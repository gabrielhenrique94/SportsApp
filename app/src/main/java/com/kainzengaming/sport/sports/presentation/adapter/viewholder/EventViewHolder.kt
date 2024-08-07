package com.kainzengaming.sport.sports.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kainzengaming.sport.R
import com.kainzengaming.sport.databinding.ViewholderSportsEventBinding
import com.kainzengaming.sport.sports.presentation.adapter.model.EventHolder
import com.kainzengaming.sport.utils.BaseViewHolder

class EventViewHolder private constructor(
    private val binding: ViewholderSportsEventBinding,
    private val onEventClickListener: (EventHolder) -> Unit
) :
    BaseViewHolder<EventHolder>(binding.root) {

    override fun bind(data: EventHolder) {
        with(binding) {
            this.root.setOnClickListener {
                onEventClickListener(data)
            }
            competitor1TextView.text = data.name.firstCompetitor()
            competitor2TextView.text = data.name.secondCompetitor()
            countdownTimer.setTimer(data.startTime)
            eventFavoriteImageView.setImageResource(
                if (data.isFavorite)
                    R.drawable.ic_favorite_event_selected
                else
                    R.drawable.ic_favorite_event_unselected
            )
        }
    }

    companion object {
        fun getViewHolder(
            parent: ViewGroup,
            onEventClickListener: (EventHolder) -> Unit
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

    private fun String.firstCompetitor() = this.split('-').first()
    private fun String.secondCompetitor() = this.split('-').last().trim()
}