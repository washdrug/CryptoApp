package com.example.cryptoapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.cryptoapp.data.network.model.CoinNameDto

class CoinInfoDiffCallback : DiffUtil.ItemCallback<CoinNameDto>() {
    override fun areItemsTheSame(oldItem: CoinNameDto, newItem: CoinNameDto): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: CoinNameDto, newItem: CoinNameDto): Boolean {
        return oldItem == newItem
    }
}