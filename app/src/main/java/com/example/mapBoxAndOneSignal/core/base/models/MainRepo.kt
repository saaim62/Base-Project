package com.example.mapBoxAndOneSignal.core.base.models

import com.example.mapBoxAndOneSignal.core.ApiManager
import com.example.mapBoxAndOneSignal.core.Resource
import com.example.mapBoxAndOneSignal.core.koin.providers.models.SearchResponse


class MainRepo(
    private val apiManager: ApiManager

) : BaseRepo(apiManager) {
    suspend fun searchPlayers(query: String): Resource<SearchResponse> {
        return apiManager.searchPlayers(query)
    }
}