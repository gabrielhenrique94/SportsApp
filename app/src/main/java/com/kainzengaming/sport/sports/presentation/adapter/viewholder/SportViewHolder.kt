package com.kainzengaming.sport.sports.presentation.adapter.viewholder

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kainzengaming.sport.R
import com.kainzengaming.sport.databinding.ViewholderSportsEventBinding
import com.kainzengaming.sport.databinding.ViewholderSportsTitleBinding
import com.kainzengaming.sport.sports.domain.model.Event
import com.kainzengaming.sport.sports.domain.model.Sport
import com.kainzengaming.sport.sports.presentation.adapter.model.EventHolder
import com.kainzengaming.sport.sports.presentation.adapter.model.SportHolder
import com.kainzengaming.sport.utils.BaseViewHolder

class SportViewHolder private constructor(
    private val binding: ViewholderSportsTitleBinding,
    private val onSportsFavoriteClickListener: (SportHolder) -> Unit,
    private val onExpandClickListener: (SportHolder) -> Unit
) :
    BaseViewHolder<SportHolder>(binding.root) {

    override fun bind(data: SportHolder) {
        with(binding) {
            collapseIcon.setOnClickListener { onExpandClickListener(data) }
            sportsName.text = data.name
            favoriteSwitch.isChecked = data.isFavorite
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
            onSportsFavoriteClickListener: (SportHolder) -> Unit,
            onExpandClickListener: (SportHolder) -> Unit
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