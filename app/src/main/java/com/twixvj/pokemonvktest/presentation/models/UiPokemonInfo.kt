package com.twixvj.pokemonvktest.presentation.models

import kotlinx.collections.immutable.ImmutableList

data class UiPokemonInfo(
    val number: String,
    val name: String,
    val height: String,
    val weight: String,
    val stats: ImmutableList<UiStat>,
    val image: String,
)
