package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.presentation.CoinDetailFragment
import com.example.cryptoapp.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(coinDetailFragment: CoinDetailFragment)

    fun inject(coinPriceListActivity: CoinPriceListActivity)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): ApplicationComponent
    }

}