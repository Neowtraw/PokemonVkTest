package com.twixvj.pokemonvktest.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.twixvj.pokemonvktest.presentation.home.AllPokemonsScreen
import com.twixvj.pokemonvktest.presentation.info.PokemonInfoScreen
import com.twixvj.pokemonvktest.presentation.navigation.NavRoute.AllPokemonsScreenRoute.ARG_NAME

@Composable
fun NavGraph(
    state: NavState,
    startDestination: String,
    padding: PaddingValues,
) {
    NavHost(
        navController = state.navController,
        startDestination = startDestination,
        modifier = Modifier.padding(padding),
    ) {

        composable(NavRoute.AllPokemonsScreenRoute.route) {
            AllPokemonsScreen(onPokemonSelected = { name ->
                state.navigateTo(
                    screen = NavRoute.PokemonInfoScreenRoute,
                    arguments = listOf(ARG_NAME to name),
                )
            })
        }

        composable(
            NavRoute.PokemonInfoScreenRoute.route,
            arguments = listOf(navArgument(ARG_NAME) {
                type = NavType.StringType
                nullable = false
            })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString(ARG_NAME)

            PokemonInfoScreen(
                name = name ?: "",
                onPressBack = state::onBackClick,
            )
        }
    }
}
