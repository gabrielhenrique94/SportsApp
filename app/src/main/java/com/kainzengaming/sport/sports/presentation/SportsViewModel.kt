package com.kainzengaming.sport.sports.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kainzengaming.sport.R
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.usecase.FavoriteEventUseCase
import com.kainzengaming.sport.sports.domain.usecase.GetSportsUseCases
import com.kainzengaming.sport.sports.presentation.mapper.toDataUi
import com.kainzengaming.sport.sports.presentation.mapper.toEventDomain
import com.kainzengaming.sport.sports.presentation.mapper.toEventsDataUi
import com.kainzengaming.sport.sports.presentation.model.EventDataUi
import com.kainzengaming.sport.sports.presentation.model.EventsDataUi
import com.kainzengaming.sport.sports.presentation.model.SportDataUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SportsViewModel @Inject constructor(
    private val getSportsUseCases: GetSportsUseCases,
    private val favoriteEventUseCase: FavoriteEventUseCase
) :
    ViewModel() {
    private val _sportsLiveData: MutableLiveData<List<Any>> = MutableLiveData()
    val sportsLiveData: LiveData<List<Any>> = _sportsLiveData

    private val _errorLiveData: MutableLiveData<Int> = MutableLiveData()
    val errorLiveData: LiveData<Int> = _errorLiveData

    private val holderList = mutableListOf<Any>()

    fun onResume() {
        getSports()
    }

    fun onEventClick(event: EventDataUi) {
        updateEventHolderState(event)
        favoriteEvent(event.toEventDomain())
        updateUI()
    }

    fun onSportsExpandClick(sport: SportDataUi) {
        val position = holderList.indexOf(sport)
        if (sport.isOpened) {
            collapse(sport, position)
        } else {
            expand(sport, position)
        }
        updateUI()
    }

    fun onSportsFilterClick(sport: SportDataUi) {
        val position = holderList.indexOf(sport)
        val newSport = sport.copy(isFiltered = !sport.isFiltered)
        holderList[position] = newSport
        if (sport.isOpened) {
            holderList.removeAll { holder ->
                holder is EventsDataUi && holder.sportId == sport.id
            }
            holderList.add(position + 1, newSport.toEventsDataUi())
        }
        updateUI()
    }

    private fun getSports() {
        viewModelScope.launch {
            getSportsUseCases()
                .catch { e ->
                    e.printStackTrace()
                    _errorLiveData.value = R.string.event_error
                }
                .collect { sports ->
                    if (sports.isEmpty()) {
                        _errorLiveData.value = R.string.event_placeholder
                    } else {
                        holderList.addAll(sports.toDataUi())
                        updateUI()
                    }
                }
        }
    }

    private fun favoriteEvent(event: Event) {
        viewModelScope.launch {
            favoriteEventUseCase(event)
        }
    }

    private fun updateEventHolderState(event: EventDataUi) {
        val newEvent = event.copy(isFavorite = event.isFavorite.not())
        //Update on Sports
        val sportHolder =
            holderList.find { it is SportDataUi && it.id == event.sportId } as SportDataUi
        val eventHolder = sportHolder.events.find { it.id == event.id }
        val eventHolderPosition = sportHolder.events.indexOf(eventHolder)
        sportHolder.events[eventHolderPosition] = newEvent
        //Update on Events
        if (sportHolder.isOpened) {
            val position = holderList.indexOf(sportHolder)
            holderList[position + 1] = sportHolder.toEventsDataUi()
        }
    }

    private fun expand(
        sport: SportDataUi,
        position: Int
    ) {
        holderList[position] = sport.copy(isOpened = true)
        holderList.add(position + 1, sport.toEventsDataUi())
    }

    private fun collapse(
        sport: SportDataUi,
        position: Int
    ) {
        holderList.removeAll { holder ->
            holder is EventsDataUi && holder.sportId == sport.id
        }
        holderList[position] = sport.copy(isOpened = false)
    }

    private fun updateUI() {
        val newList = ArrayList<Any>(holderList)
        _sportsLiveData.value = newList
    }
}