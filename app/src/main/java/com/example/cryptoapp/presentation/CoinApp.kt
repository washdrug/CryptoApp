package com.example.cryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import com.example.cryptoapp.data.workers.RefreshDataWorkerFactory
import com.example.cryptoapp.di.ApplicationComponent
import com.example.cryptoapp.di.DaggerApplicationComponent
import javax.inject.Inject

class CoinApp : Application(), Configuration.Provider {

    @Inject
    lateinit var refreshDataWorkerFactory: RefreshDataWorkerFactory

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(refreshDataWorkerFactory)
            .build()
    }
}