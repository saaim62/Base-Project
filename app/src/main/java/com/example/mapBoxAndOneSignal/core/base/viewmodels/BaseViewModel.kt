package com.example.mapBoxAndOneSignal.core.base.viewmodels

import androidx.lifecycle.ViewModel
import com.example.mapBoxAndOneSignal.core.base.models.BaseRepo

open class BaseViewModel(private val baseRepo: BaseRepo) : ViewModel() {}