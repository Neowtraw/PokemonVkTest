package com.twixvj.pokemonvktest.presentation.info

import com.twixvj.pokemonvktest.domain.model.PokemonInfo

sealed interface PokemonInfoAction {
    data class Init(val name: String) : PokemonInfoAction
    data class PokemonInfoLoaded(val result: PokemonInfo) : PokemonInfoAction
    data class LoadError(val error: String) : PokemonInfoAction
}
