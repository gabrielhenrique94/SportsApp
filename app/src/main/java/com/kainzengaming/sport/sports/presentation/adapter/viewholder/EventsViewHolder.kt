package com.kainzengaming.sport.sports.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kainzengaming.sport.databinding.ViewholderSportsEventsBinding
import com.kainzengaming.sport.sports.presentation.adapter.EventsAdapter
import com.kainzengaming.sport.sports.presentation.model.EventDataUi
import com.kainzengaming.sport.sports.presentation.model.EventsDataUi

class EventsViewHolder private constructor(
    binding: ViewholderSportsEventsBinding,
    onEventClickListener: (EventDataUi) -> Unit
) : ViewHolder(binding.root) {
    private val eventsAdapter: EventsAdapter = EventsAdapter(onEventClickListener)

    init {
        with(binding.eventsRecyclerView) {
            adapter = eventsAdapter
            isNestedScrollingEnabled = false
        }
    }

    fun bind(data: EventsDataUi) {
        val newList = ArrayList<EventDataUi>(data.events)
        eventsAdapter.submitList(newList)
    }

    companion object {
        fun getViewHolder(
            parent: ViewGroup,
            onEventClickListener: (EventDataUi) -> Unit
        ) =
            EventsViewHolder(
                ViewholderSportsEventsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onEventClickListener
            )
    }

}