package com.twixvj.pokemonvktest.presentation.navigation

sealed class NavRoute(
    val route: String,
    val routePath: String = "",
) {
    data object AllPokemonsScreenRoute : NavRoute(
        route = "all_pokemons_screen",
    ) {
        const val ARG_NAME = "name"
    }

    data object PokemonInfoScreenRoute : NavRoute(
        route = "pokemon_info_screen?name={name}",
        routePath = "pokemon_info_screen",
    )
}
