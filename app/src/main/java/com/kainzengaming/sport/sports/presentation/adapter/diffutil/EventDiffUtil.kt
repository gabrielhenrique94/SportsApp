package com.kainzengaming.sport.sports.presentation.adapter.diffutil

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.kainzengaming.sport.sports.presentation.model.EventDataUi

class EventDiffUtil : ItemCallback<EventDataUi>() {

    override fun areItemsTheSame(oldItem: EventDataUi, newItem: EventDataUi): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: EventDataUi, newItem: EventDataUi): Boolean =
        oldItem == newItem
}