package com.twixvj.pokemonvktest.presentation.home

import com.twixvj.pokemonvktest.domain.model.Pokemon
import com.twixvj.pokemonvktest.presentation.models.UiPokemon
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class AllPokemonsState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val pokemons: ImmutableList<UiPokemon> = persistentListOf(),
)
