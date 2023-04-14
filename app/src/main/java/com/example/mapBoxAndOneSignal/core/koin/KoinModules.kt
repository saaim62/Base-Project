package com.example.mapBoxAndOneSignal.core.koin


import com.example.mapBoxAndOneSignal.core.base.modules.accountRepoModule
import com.example.mapBoxAndOneSignal.core.base.modules.accountViewModelModule
import com.example.mapBoxAndOneSignal.core.base.modules.baseRepoModule
import com.example.mapBoxAndOneSignal.core.base.modules.baseViewModelModule
import com.example.mapBoxAndOneSignal.core.koin.modules.apiModule
import com.example.mapBoxAndOneSignal.core.modules.retrofitModule
import org.koin.core.module.Module

fun getListOfModules(): List<Module> {

    return (listOf(
        apiModule,
        accountRepoModule,
        accountViewModelModule,
        retrofitModule,
        baseRepoModule,
        baseViewModelModule
    ))
}