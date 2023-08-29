package com.example.cryptoapp.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.mapper.CoinMapper
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.domain.CoinInfo
import com.example.cryptoapp.domain.CoinInfoRepository
import kotlinx.coroutines.delay

class CoinInfoRepositoryImpl(private val context: Context) : CoinInfoRepository {

    private val coinInfoDao = AppDatabase.getInstance(context).coinPriceInfoDao()
    private val apiService = ApiFactory.apiService
    private val mapper = CoinMapper()
    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return coinInfoDao.getCoinInfoList().map {
            it.map { dbModel ->
                mapper.mapDbModelToEntity(dbModel)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return coinInfoDao.getCoinInfo(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadData() {
        while (true) {
            val topCoins = apiService.getTopCoinsInfo(limit = 50)
            val fSyms = mapper.mapNamesListToString(topCoins)
            val topCoinsInfoJsonContainer = apiService.getFullPriceList(fSyms = fSyms)
            val topCoinsInfoDtoList = mapper.mapJsonContainerToList(topCoinsInfoJsonContainer)
            val topCoinsInfoDbModel = topCoinsInfoDtoList.map { mapper.mapDtoToDBModel(it) }
            coinInfoDao.insertPriceList(topCoinsInfoDbModel)
            delay(10000)
        }
    }
}