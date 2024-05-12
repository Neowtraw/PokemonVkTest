package com.twixvj.pokemonvktest.data.model

import com.squareup.moshi.Json

data class PokemonModel(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
) {
    private val number get() =
        url.split("/").dropLast(1).last()

    val numberString get() = when(number.length) {
        1 -> "#00$number"
        2 -> "#0$number"
        else -> "#$number"
    }

    val imageUrl get() =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"
}
