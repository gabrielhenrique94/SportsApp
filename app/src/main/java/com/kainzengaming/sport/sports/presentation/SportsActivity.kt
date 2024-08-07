package com.kainzengaming.sport.sports.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kainzengaming.sport.databinding.ActivitySportsBinding
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.presentation.adapter.SportsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySportsBinding
    private val viewModel: SportsViewModel by viewModels()
    private val sportsAdapter = SportsAdapter(listOf(), ::onEventClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        observeViewModel()
    }

    private fun initViews() {
        binding.sportsRecyclerView.adapter = sportsAdapter
    }

    private fun observeViewModel() {
        viewModel.sportsLiveData.observe(this) { sports ->
            sportsAdapter.updateList(sports)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }
    private fun onEventClick(event: Event) {
        viewModel.onEventClick(event)
    }


}