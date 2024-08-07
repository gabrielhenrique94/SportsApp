package com.kainzengaming.sport.sports.presentation.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.presentation.adapter.mapper.toEventsHolder
import com.kainzengaming.sport.sports.presentation.adapter.mapper.toSportHolderList
import com.kainzengaming.sport.sports.presentation.adapter.model.EventHolder
import com.kainzengaming.sport.sports.presentation.adapter.model.EventsHolder
import com.kainzengaming.sport.sports.presentation.adapter.model.Holder
import com.kainzengaming.sport.sports.presentation.adapter.model.SportHolder
import com.kainzengaming.sport.sports.presentation.adapter.viewholder.EventsViewHolder
import com.kainzengaming.sport.sports.presentation.adapter.viewholder.SportViewHolder
import com.kainzengaming.sport.utils.BaseViewHolder

const val TYPE_SPORT = 0
const val TYPE_EVENT = 1
class SportsAdapter(fullSportsList: List<Sport>) :
    RecyclerView.Adapter<BaseViewHolder<out Holder>>() {

    private val holderList = fullSportsList.toSportHolderList().toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<out Holder> =
        when (viewType) {
            TYPE_SPORT -> SportViewHolder.getViewHolder(
                parent,
                ::onSportsFavoriteClick,
                ::onSportsExpandClick
            )
            TYPE_EVENT -> EventsViewHolder.getViewHolder(parent, ::onEventClick)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(sports: List<Sport>) {
        holderList.clear()
        holderList.addAll(sports.toSportHolderList())
        notifyDataSetChanged()
    }
    private fun onEventClick(eventHolder: EventHolder) {

    }

    private fun onSportsFavoriteClick(sportHolder: SportHolder) {

    }

    private fun onSportsExpandClick(sportHolder: SportHolder) {
        val position = holderList.indexOf(sportHolder)
        if (sportHolder.isOpened) {
            collapse(sportHolder, position)
        } else {
            expand(sportHolder, position)
        }
    }

    private fun expand(
        sportHolder: SportHolder,
        position: Int
    ) {
        sportHolder.isOpened = true
        holderList.add(position + 1, sportHolder.toEventsHolder())
        notifyItemChanged(position)
        notifyItemInserted(position + 1)
    }

    private fun collapse(
        sportHolder: SportHolder,
        position: Int
    ) {
        holderList.removeAll { holder ->
            holder is EventsHolder && holder.sportId == sportHolder.id
        }
        sportHolder.isOpened = false
        notifyItemChanged(position)
        notifyItemRemoved(position + 1)
    }

    override fun getItemCount(): Int = holderList.size

    override fun onBindViewHolder(holder: BaseViewHolder<out Holder>, position: Int) {
        when (holder) {
            is SportViewHolder -> holder.bind(holderList[position] as SportHolder)
            is EventsViewHolder -> holder.bind(holderList[position] as EventsHolder)
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (holderList[position]) {
            is SportHolder -> TYPE_SPORT
            is EventsHolder -> TYPE_EVENT
            else -> throw IllegalArgumentException("Invalid view type")
        }
}
