package com.example.coincap.coin_cap_feature.domain.repository

import com.example.coincap.coin_cap_feature.domain.model.AllCoin
import com.example.coincap.coin_cap_feature.domain.model.CoinDetail
import com.example.coincap.coin_cap_feature.domain.model.Data

interface CoinRepository {

    suspend fun getCoins(): List<Data>

    suspend fun getCoinById(coinId: String): CoinDetail
}