package com.twixvj.pokemonvktest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.twixvj.pokemonvktest.presentation.navigation.NavRoute
import com.twixvj.pokemonvktest.presentation.navigation.NavState
import com.twixvj.pokemonvktest.presentation.navigation.setupNavGraph
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
                    setupNavGraph(
                        state = state,
                        startDestination = NavRoute.AllPokemonsScreenRoute.route,
                        padding = padding,
                    )
                }
            }
        }
    }
}
