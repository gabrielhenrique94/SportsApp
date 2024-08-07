package com.kainzengaming.sport.sports.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kainzengaming.sport.databinding.ViewholderSportsEventBinding
import com.kainzengaming.sport.databinding.ViewholderSportsEventsBinding
import com.kainzengaming.sport.sports.presentation.adapter.EventsAdapter
import com.kainzengaming.sport.sports.presentation.adapter.model.EventHolder
import com.kainzengaming.sport.sports.presentation.adapter.model.EventsHolder
import com.kainzengaming.sport.utils.BaseViewHolder

class EventsViewHolder private constructor(
    binding: ViewholderSportsEventsBinding,
    onEventClickListener: (EventHolder) -> Unit
) : BaseViewHolder<EventsHolder>(binding.root) {
    private val eventsAdapter: EventsAdapter = EventsAdapter(onEventClickListener)

    init {
        with(binding.eventsRecyclerView) {
            adapter = eventsAdapter
            isNestedScrollingEnabled = false
        }
    }

    override fun bind(data: EventsHolder) {
        eventsAdapter.submitList(data.events)
    }

    companion object {
        fun getViewHolder(
            parent: ViewGroup,
            onEventClickListener: (EventHolder) -> Unit
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