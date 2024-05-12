package com.twixvj.pokemonvktest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.twixvj.pokemonvktest.presentation.navigation.NavRoute
import com.twixvj.pokemonvktest.presentation.navigation.NavState
import com.twixvj.pokemonvktest.presentation.navigation.NavGraph
import com.twixvj.pokemonvktest.presentation.theme.PokemonVkTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = NavState(rememberNavController())

            PokemonVkTestTheme {
                Scaffold { padding ->
                    NavGraph(
                        state = state,
                        startDestination = NavRoute.AllPokemonsScreenRoute.route,
                        padding = padding,
                    )
                }
            }
        }
    }
}
