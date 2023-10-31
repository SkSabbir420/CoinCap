package com.example.coincap.coin_cap_feature.domain.use_case

import com.example.coincap.coin_cap_feature.domain.model.Data
import com.example.coincap.coin_cap_feature.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Data>>> = flow {
        try {
            emit(Resource.Loading<List<Data>>())
            val coins = repository.getCoins().map { it }
            emit(Resource.Success<List<Data>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Data>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Data>>("Couldn't reach server. Check your internet connection."))
        }
    }
}