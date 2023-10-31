package com.example.coincap.coin_cap_feature.domain.model

data class Data(
    val currencySymbol: String,
    val id: String,
    val rateUsd: String,
    val symbol: String,
    val type: String
)