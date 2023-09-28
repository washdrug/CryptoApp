package com.example.cryptoapp.di

import com.example.cryptoapp.data.workers.ChildWorkerFactory
import com.example.cryptoapp.data.workers.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @IntoMap
    @Binds
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorker(factory: RefreshDataWorker.Factory): ChildWorkerFactory
}