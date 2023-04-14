package com.example.mapBoxAndOneSignal.core.koin.modules

import android.content.Context
import com.example.mapBoxAndOneSignal.core.ApiManager
import com.example.mapBoxAndOneSignal.core.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun getApiInterface(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    fun getAPIManger(
        apiInterface: ApiService,
        context: Context,
    ): ApiManager {
        return ApiManager(apiInterface, context)
    }

    single { getAPIManger(get(), get()) }
    single { getApiInterface(get()) }
}