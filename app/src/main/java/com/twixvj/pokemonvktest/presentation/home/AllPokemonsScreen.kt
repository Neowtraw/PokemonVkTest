package com.twixvj.pokemonvktest.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.twixvj.pokemonvktest.presentation.components.ProgressBar
import com.twixvj.pokemonvktest.presentation.home.components.ErrorDialog
import com.twixvj.pokemonvktest.presentation.home.components.PokemonList

@Composable
fun AllPokemonsScreen(
    onPokemonSelected: (String) -> Unit,
) {
    val viewModel = hiltViewModel<AllPokemonsViewModel>()
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
            .padding(horizontal = 12.dp),
    ) {
        val lifecycleOwner = LocalLifecycleOwner.current
        LaunchedEffect(key1 = lifecycleOwner) {
            if (lifecycleOwner.lifecycle.currentState == Lifecycle.State.STARTED) {
                viewModel.submitAction(AllPokemonsAction.Init)
            }
        }

        when (state) {
            AllPokemonsViewState.Loading -> {
                ProgressBar()
            }

            is AllPokemonsViewState.Result -> {
                PokemonList(
                    pokemons = (state as AllPokemonsViewState.Result).result,
                    onPokemonSelected = onPokemonSelected,
                )
            }

            is AllPokemonsViewState.Error -> {
                ErrorDialog(text = (state as AllPokemonsViewState.Error).error)
            }
        }
    }
}
