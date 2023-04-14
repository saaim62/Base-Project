package com.example.mapBoxAndOneSignal.core.koin.providers.models

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("player") val players: List<Player>
)

data class Player(
    @SerializedName("idPlayer") val idPlayer: String? = null,
    @SerializedName("strPlayer") val strPlayer: String? = null,
    @SerializedName("strNationality") val strNationality: String? = null,
    @SerializedName("strTeam") val strTeam: String? = null,
    @SerializedName("strSport") val strSport: String? = null,
    @SerializedName("dateBorn") val dateBorn: String? = null,
    @SerializedName("strPosition") val strPosition: String? = null,
    @SerializedName("strHeight") val strHeight: String? = null,
    @SerializedName("strWeight") val strWeight: String? = null,
    @SerializedName("strThumb") val strThumb: String? = null
)