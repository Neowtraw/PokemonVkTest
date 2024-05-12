package com.twixvj.pokemonvktest.data.model

import com.squareup.moshi.Json

data class PokemonInfoResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "weight") val weight: Long,
    @Json(name = "height") val height: Long,
    @Json(name = "stats") val stats: List<StatsResponse>,
) {
    val idString get() = when(id.toString().length) {
        1 -> "#00$id"
        2 -> "#0$id"
        else -> "#$id"
    }

    val image: String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
}
