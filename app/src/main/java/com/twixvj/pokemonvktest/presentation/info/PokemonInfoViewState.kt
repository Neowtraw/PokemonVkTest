package com.twixvj.pokemonvktest.presentation.info

import com.twixvj.pokemonvktest.domain.model.PokemonInfo

sealed interface PokemonInfoViewState {
    data object Loading: PokemonInfoViewState
    data class Result(val result: PokemonInfo?) : PokemonInfoViewState
    data class Error(val error: String) : PokemonInfoViewState
}
