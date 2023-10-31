package com.example.coincap.coin_cap_feature.data.remote

import com.example.coincap.coin_cap_feature.domain.model.AllCoin
import com.example.coincap.coin_cap_feature.domain.model.CoinDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinCapApi {

    @GET("v2/rates")
    suspend fun getCoins(): AllCoin

    @GET("v2/rates/{id}")
    suspend fun getCoinById(@Path("id") coinId: String): CoinDetail
}