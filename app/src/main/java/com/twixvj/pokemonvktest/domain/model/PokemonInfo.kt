package com.twixvj.pokemonvktest.domain.model

data class PokemonInfo(
    val number: String,
    val name: String,
    val height: Long,
    val weight: Long,
    val stats: List<Stat>,
    val image: String,
)
