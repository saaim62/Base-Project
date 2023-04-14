package com.example.mapBoxAndOneSignal.ui

import androidx.lifecycle.viewModelScope
import com.example.mapBoxAndOneSignal.core.base.viewmodels.BaseViewModel
import com.example.mapBoxAndOneSignal.core.Resource
import com.example.mapBoxAndOneSignal.core.base.models.MainRepo
import com.example.mapBoxAndOneSignal.core.koin.providers.models.Player
import com.example.mapBoxAndOneSignal.core.koin.providers.models.SearchResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepo) : BaseViewModel(repository) {
    private val playersObserver = MutableStateFlow<Resource<SearchResponse>>(Resource.Loading())
    val player: Player? = null

    fun searchPlayers(
        query: String,
        returnApiResponse: (Resource<SearchResponse>) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            playersObserver.emit(Resource.Loading())
            when (val apiResponse = repository.searchPlayers(query)) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    playersObserver.emit(apiResponse)
                    returnApiResponse.invoke(apiResponse)
                }
                is Resource.Error -> {
                    playersObserver.emit(Resource.Error(apiResponse.message))
                }
            }
        }
    }
}
