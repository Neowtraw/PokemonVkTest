package com.twixvj.pokemonvktest.presentation.home

sealed interface AllPokemonsSideEffect {
    data object LoadPokemons : AllPokemonsSideEffect
}
