package com.twixvj.pokemonvktest.presentation.home

import com.twixvj.pokemonvktest.domain.model.Pokemon

sealed interface AllPokemonsAction {
    data object Init : AllPokemonsAction
    data class PokemonsLoaded(val result: List<Pokemon>) : AllPokemonsAction
    data class LoadError(val error: String) : AllPokemonsAction
}
