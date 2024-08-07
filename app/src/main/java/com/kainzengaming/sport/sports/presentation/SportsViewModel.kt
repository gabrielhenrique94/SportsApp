package com.kainzengaming.sport.sports.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.domain.usecase.FavoriteEventUseCase
import com.kainzengaming.sport.sports.domain.usecase.GetSportsUseCases
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
    private val _sportsLiveData: MutableLiveData<List<Sport>> = MutableLiveData()
    val sportsLiveData: LiveData<List<Sport>> = _sportsLiveData

    fun onResume() {
        getSports()
    }

    fun onEventClick(event: Event) {
        favoriteEvent(event)
    }

    private fun getSports() {
        viewModelScope.launch {
            getSportsUseCases()
                .catch {
                    //TODO: show error message
                }
                .collect { sports ->
                    _sportsLiveData.value = sports
                }
        }
    }

    private fun favoriteEvent(event: Event) {
        viewModelScope.launch {
            favoriteEventUseCase(event)
            getSports()
        }
    }



}