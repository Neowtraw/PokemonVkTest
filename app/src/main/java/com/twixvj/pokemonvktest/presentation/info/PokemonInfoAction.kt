package com.twixvj.pokemonvktest.presentation.info

import com.twixvj.pokemonvktest.presentation.models.UiPokemonInfo

sealed interface PokemonInfoAction {
    data class Init(val name: String) : PokemonInfoAction
    data class PokemonInfoLoaded(val result: UiPokemonInfo) : PokemonInfoAction
    data class LoadError(val error: String) : PokemonInfoAction
}
