package com.twixvj.pokemonvktest.presentation.info


sealed interface PokemonInfoSideEffect {
    data object LoadPokemonInfo : PokemonInfoSideEffect
}
