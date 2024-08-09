package com.kainzengaming.sport.sports.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kainzengaming.sport.sports.presentation.adapter.diffutil.EventSportsDiffUtil
import com.kainzengaming.sport.sports.presentation.adapter.viewholder.EventsViewHolder
import com.kainzengaming.sport.sports.presentation.adapter.viewholder.SportViewHolder
import com.kainzengaming.sport.sports.presentation.model.EventDataUi
import com.kainzengaming.sport.sports.presentation.model.EventsDataUi
import com.kainzengaming.sport.sports.presentation.model.SportDataUi

const val TYPE_SPORT = 0
const val TYPE_EVENT = 1
class SportsAdapter(
    private val onEventClick: (EventDataUi) -> Unit,
    private val onSportsFilterClick: (SportDataUi) -> Unit ,
    private val onSportsExpandClick: (SportDataUi) -> Unit
) : ListAdapter<Any, ViewHolder>(EventSportsDiffUtil()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is SportViewHolder -> holder.bind(getItem(position) as SportDataUi)
            is EventsViewHolder -> holder.bind(getItem(position) as EventsDataUi)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        when (viewType) {
            TYPE_SPORT -> SportViewHolder.getViewHolder(
                parent,
                onSportsFilterClick,
                onSportsExpandClick
            )
            TYPE_EVENT -> EventsViewHolder.getViewHolder(parent, onEventClick)
            else -> throw IllegalArgumentException("Invalid view type")
        }

    override fun getItemViewType(position: Int): Int =
        when (getItem(position)) {
            is SportDataUi -> TYPE_SPORT
            is EventsDataUi -> TYPE_EVENT
            else -> throw IllegalArgumentException("Invalid view type")
        }
}
