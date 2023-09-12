package com.example.cryptoapp.domain

import javax.inject.Inject

class GetCoinInfoListUseCase @Inject constructor(private val repository: CoinInfoRepository) {

    operator fun invoke() = repository.getCoinInfoList()
}