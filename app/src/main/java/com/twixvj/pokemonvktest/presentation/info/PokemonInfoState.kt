package com.twixvj.pokemonvktest.presentation.info

import com.twixvj.pokemonvktest.domain.model.PokemonInfo

data class PokemonInfoState(
    val name: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val info: PokemonInfo? = null,
)
