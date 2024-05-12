package com.twixvj.pokemonvktest.presentation.home

import com.twixvj.pokemonvktest.domain.model.Pokemon

data class AllPokemonsState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val pokemons: List<Pokemon> = listOf(),
)
