package com.example.coincap.coin_cap_feature.presentation.coin_detail

import com.example.coincap.coin_cap_feature.domain.model.CoinDetail


data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
