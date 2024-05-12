package com.twixvj.pokemonvktest.presentation.info

import com.twixvj.pokemonvktest.presentation.models.UiPokemonInfo

sealed interface PokemonInfoViewState {
    data object Loading: PokemonInfoViewState
    data class Result(val result: UiPokemonInfo?) : PokemonInfoViewState
    data class Error(val error: String) : PokemonInfoViewState
}
