package com.example.coincap.coin_cap_feature.data.repository

import com.example.coincap.coin_cap_feature.data.remote.CoinCapApi
import com.example.coincap.coin_cap_feature.domain.model.AllCoin
import com.example.coincap.coin_cap_feature.domain.model.Data
import com.example.coincap.coin_cap_feature.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinCapApi
) : CoinRepository {

    override suspend fun getCoins(): List<Data> {
        return api.getCoins().data
    }
}