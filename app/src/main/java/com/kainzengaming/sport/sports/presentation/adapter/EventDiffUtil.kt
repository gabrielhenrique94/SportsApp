package com.kainzengaming.sport.sports.presentation.adapter

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.kainzengaming.sport.sports.presentation.adapter.model.EventHolder

class EventDiffUtil : ItemCallback<EventHolder>() {

    override fun areItemsTheSame(oldItem: EventHolder, newItem: EventHolder): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: EventHolder, newItem: EventHolder): Boolean =
        oldItem == newItem
}