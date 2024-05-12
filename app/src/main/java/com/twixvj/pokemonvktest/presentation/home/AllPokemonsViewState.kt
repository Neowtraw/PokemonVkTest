package com.twixvj.pokemonvktest.presentation.home

import com.twixvj.pokemonvktest.domain.model.Pokemon

sealed interface AllPokemonsViewState {
    data object Loading: AllPokemonsViewState
    data class Result(val result: List<Pokemon>) : AllPokemonsViewState
    data class Error(val error: String) : AllPokemonsViewState
}
