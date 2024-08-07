package com.kainzengaming.sport.sports.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.kainzengaming.sport.sports.presentation.adapter.model.EventHolder
import com.kainzengaming.sport.sports.presentation.adapter.viewholder.EventViewHolder

class EventsAdapter(
    private val onEventClickListener: (EventHolder) -> Unit
) : ListAdapter<EventHolder, EventViewHolder>(EventDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder.getViewHolder(parent, onEventClickListener)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}