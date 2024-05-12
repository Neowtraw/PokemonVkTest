package com.twixvj.pokemonvktest.presentation.home

import com.twixvj.pokemonvktest.presentation.models.UiPokemon
import kotlinx.collections.immutable.ImmutableList

sealed interface AllPokemonsViewState {
    data object Loading : AllPokemonsViewState
    data class Result(val result: ImmutableList<UiPokemon>) : AllPokemonsViewState
    data class Error(val error: String) : AllPokemonsViewState
}
