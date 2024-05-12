package com.twixvj.pokemonvktest.presentation.info

import com.twixvj.pokemonvktest.presentation.models.UiPokemonInfo

data class PokemonInfoState(
    val name: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val info: UiPokemonInfo? = null,
)
