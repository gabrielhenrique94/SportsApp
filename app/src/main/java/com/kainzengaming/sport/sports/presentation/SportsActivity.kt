package com.kainzengaming.sport.sports.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kainzengaming.sport.databinding.ActivitySportsBinding
import com.kainzengaming.sport.sports.presentation.adapter.SportsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySportsBinding
    private val viewModel: SportsViewModel by viewModels()
    private val sportsAdapter = SportsAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySportsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sportsRecyclerView.adapter = sportsAdapter

        viewModel.sportsLiveData.observe(this) { sports ->
            sportsAdapter.updateList(sports)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getSports()
    }

}