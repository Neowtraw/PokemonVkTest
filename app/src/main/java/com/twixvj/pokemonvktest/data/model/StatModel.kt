package com.twixvj.pokemonvktest.data.model

import com.squareup.moshi.Json

data class StatModel(
    @Json(name = "name") val name: String,
)
