package com.twixvj.pokemonvktest.presentation.home

import com.twixvj.pokemonvktest.presentation.models.UiPokemon
import kotlinx.collections.immutable.ImmutableList

sealed interface AllPokemonsAction {
    data object Init : AllPokemonsAction
    data class PokemonsLoaded(val result: ImmutableList<UiPokemon>) : AllPokemonsAction
    data class LoadError(val error: String) : AllPokemonsAction
}
