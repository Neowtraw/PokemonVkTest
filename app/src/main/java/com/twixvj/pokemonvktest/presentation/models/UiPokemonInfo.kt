package com.twixvj.pokemonvktest.presentation.models

import kotlinx.collections.immutable.ImmutableList

data class UiPokemonInfo(
    val number: String,
    val name: String,
    val height: Long,
    val weight: Long,
    val stats: ImmutableList<UiStat>,
    val image: String,
)
