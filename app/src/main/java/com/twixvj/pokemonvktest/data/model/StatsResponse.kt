package com.twixvj.pokemonvktest.data.model

import com.squareup.moshi.Json

data class StatsResponse(
    @Json(name = "base_stat") val value: Int,
    val stat: StatModel,
)
