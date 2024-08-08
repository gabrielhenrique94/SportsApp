package com.kainzengaming.sport.sports.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kainzengaming.sport.R
import com.kainzengaming.sport.databinding.ViewholderSportsTitleBinding
import com.kainzengaming.sport.sports.presentation.model.SportDataUi
import kotlin.reflect.KProperty0

class SportViewHolder private constructor(
    private val binding: ViewholderSportsTitleBinding,
    private val onSportsFavoriteClickListener: (SportDataUi) -> Unit,
    private val onExpandClickListener: (SportDataUi) -> Unit
) : ViewHolder(binding.root) {

    fun bind(data: SportDataUi) {
        with(binding) {
            collapseIcon.setOnClickListener { onExpandClickListener(data) }
            sportsName.text = data.name
            favoriteSwitch.isChecked = data.isFiltered
            favoriteSwitch.setOnClickListener { onSportsFavoriteClickListener(data) }
            collapseIcon.setImageResource(
                if (data.isOpened) {
                    R.drawable.ic_sports_open
                } else {
                    R.drawable.ic_sports_close
                }
            )
        }
    }

    companion object {
        fun getViewHolder(
            parent: ViewGroup,
            onSportsFavoriteClickListener: (SportDataUi) -> Unit,
            onExpandClickListener: (SportDataUi) -> Unit
        ) =
            SportViewHolder(
                ViewholderSportsTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                onSportsFavoriteClickListener,
                onExpandClickListener
            )
    }
}