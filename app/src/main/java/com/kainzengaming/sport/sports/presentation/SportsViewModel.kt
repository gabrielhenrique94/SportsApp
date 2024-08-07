package com.kainzengaming.sport.sports.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.domain.usecase.GetSportsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SportsViewModel @Inject constructor(private val getSportsUseCases: GetSportsUseCases) :
    ViewModel() {
    private val _sportsLiveData: MutableLiveData<List<Sport>> = MutableLiveData()
    val sportsLiveData: LiveData<List<Sport>> = _sportsLiveData

    fun getSports() {
        viewModelScope.launch {
            val sports = getSportsUseCases(false)
            _sportsLiveData.value = sports
        }
    }
}