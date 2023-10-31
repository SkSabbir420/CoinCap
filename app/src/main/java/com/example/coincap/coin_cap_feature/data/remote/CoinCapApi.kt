package com.example.coincap.coin_cap_feature.data.remote

import com.example.coincap.coin_cap_feature.domain.model.AllCoin
import retrofit2.http.GET

interface CoinCapApi {

    @GET("v2/rates")
    suspend fun getCoins(): AllCoin
}