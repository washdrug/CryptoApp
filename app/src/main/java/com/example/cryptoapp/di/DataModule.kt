package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.data.database.AppDatabase
import com.example.cryptoapp.data.database.CoinInfoDao
import com.example.cryptoapp.data.network.ApiFactory
import com.example.cryptoapp.data.network.ApiService
import com.example.cryptoapp.data.repository.CoinInfoRepositoryImpl
import com.example.cryptoapp.domain.CoinInfoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: CoinInfoRepositoryImpl): CoinInfoRepository

    companion object {

        @ApplicationScope
        @Provides
        fun provideCoinInfoDao(application: Application): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @ApplicationScope
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}