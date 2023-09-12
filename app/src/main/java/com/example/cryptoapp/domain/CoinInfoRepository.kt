package com.example.cryptoapp.domain

import androidx.lifecycle.LiveData
import com.example.cryptoapp.di.ApplicationScope

@ApplicationScope
interface CoinInfoRepository {

    fun getCoinInfoList(): LiveData<List<CoinInfo>>

    fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo>

    fun loadData()
}