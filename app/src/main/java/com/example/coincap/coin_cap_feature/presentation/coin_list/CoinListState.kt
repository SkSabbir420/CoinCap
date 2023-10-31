package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import com.example.coincap.coin_cap_feature.domain.model.Data

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Data> = emptyList(),
    val error: String = ""
)
