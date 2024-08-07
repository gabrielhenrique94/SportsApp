package com.kainzengaming.sport.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<DATA>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: DATA)
}