package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData

interface CoinInfoRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    suspend fun loadData()
}