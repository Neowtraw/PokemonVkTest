package com.twixvj.pokemonvktest.data.model

import com.squareup.moshi.Json

data class AllPokemonsResponse(
    @Json(name = "count") val count: Int,
    @Json(name = "next") val next: String?,
    @Json(name = "previous") val previous: String?,
    @Json(name = "results") val results: List<PokemonModel>,
)
