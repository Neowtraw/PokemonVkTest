package com.twixvj.pokemonvktest.data.model

import com.squareup.moshi.Json
import com.twixvj.pokemonvktest.core.PokemonFormatters

data class PokemonModel(
    @Json(name = "name") val name: String,
    @Json(name = "url") val url: String,
) {
    private val number get() =
        url.split("/").dropLast(1).last()

    val numberString: String get() = PokemonFormatters.idFormatter.format(number.toInt())

    val imageUrl get() =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"
}
