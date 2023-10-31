package com.example.coincap.coin_cap_feature.di

import com.example.coincap.coin_cap_feature.data.remote.CoinCapApi
import com.example.coincap.coin_cap_feature.data.repository.CoinRepositoryImpl
import com.example.coincap.coin_cap_feature.domain.repository.CoinRepository
import com.example.coincap.coin_cap_feature.common.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinCapApi(): CoinCapApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinCapApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinCapApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}