package com.twixvj.pokemonvktest.presentation.navigation

import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController

@Stable
class NavState(val navController: NavHostController) {
    fun navigateTo(screen: NavRoute, arguments: List<Pair<String, Any>> = emptyList()) {
        val route = if (arguments.isEmpty().not()) {
            screen.routePath + "?" + arguments.joinToString(separator = ",") { "${it.first}=${it.second}" }
        } else {
            screen.route
        }
        navController.navigate(route)
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}
