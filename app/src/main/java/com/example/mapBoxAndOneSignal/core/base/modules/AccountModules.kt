package com.example.mapBoxAndOneSignal.core.base.modules

import com.example.mapBoxAndOneSignal.core.base.models.MainRepo
import com.example.mapBoxAndOneSignal.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val accountViewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val accountRepoModule = module {
    factory { MainRepo(get()) }
}