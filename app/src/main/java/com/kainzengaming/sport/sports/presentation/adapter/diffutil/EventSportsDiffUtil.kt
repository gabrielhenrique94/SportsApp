package com.kainzengaming.sport.sports.presentation.adapter.diffutil

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.kainzengaming.sport.sports.presentation.model.EventDataUi
import com.kainzengaming.sport.sports.presentation.model.EventsDataUi
import com.kainzengaming.sport.sports.presentation.model.SportDataUi

class EventSportsDiffUtil : ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is EventsDataUi && newItem is EventsDataUi -> oldItem.sportId == newItem.sportId
            oldItem is SportDataUi && newItem is SportDataUi -> oldItem.id == newItem.id
            else -> false
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        return when {
            oldItem is EventsDataUi && newItem is EventsDataUi -> compareLists(
                oldItem.events,
                newItem.events
            )
            oldItem is SportDataUi && newItem is SportDataUi -> oldItem == newItem
            else -> false
        }
    }

    private fun compareLists(list1: List<EventDataUi>, list2: List<EventDataUi>): Boolean {
        if (list1.size != list2.size) return false
        for (i in list1.indices) {
            if (list1[i] != list2[i]) return false
        }
        return true
    }
}