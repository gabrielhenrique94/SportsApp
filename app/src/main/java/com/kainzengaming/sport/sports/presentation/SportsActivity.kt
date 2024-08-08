package com.kainzengaming.sport.sports.presentation

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kainzengaming.sport.databinding.ActivitySportsBinding
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.presentation.adapter.SportsAdapter
import com.kainzengaming.sport.sports.presentation.model.EventDataUi
import com.kainzengaming.sport.sports.presentation.model.SportDataUi
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySportsBinding
    private val viewModel: SportsViewModel by viewModels()
    private val sportsAdapter =
        SportsAdapter(::onEventClick, ::onSportsFilterClick, ::onSportsExpandClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    private fun initViews() {
        binding.sportsRecyclerView.adapter = sportsAdapter
    }

    private fun observeViewModel() {
        viewModel.sportsLiveData.observe(this) { sports ->
            sportsAdapter.submitList(sports)
            binding.sportsRecyclerView.visibility = VISIBLE
            binding.errorTextView.visibility = GONE
        }
        viewModel.errorLiveData.observe(this) {
            binding.errorTextView.setText(it)
            binding.sportsRecyclerView.visibility = GONE
            binding.errorTextView.visibility = VISIBLE
        }
    }

    private fun onSportsExpandClick(sportDataUi: SportDataUi) {
        viewModel.onSportsExpandClick(sportDataUi)
    }

    private fun onSportsFilterClick(sportDataUi: SportDataUi) {
        viewModel.onSportsFilterClick(sportDataUi)
    }

    private fun onEventClick(event: EventDataUi) {
        viewModel.onEventClick(event)
    }
}