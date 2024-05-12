package com.twixvj.pokemonvktest.presentation.info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import com.twixvj.pokemonvktest.presentation.info.components.BackPressButton
import com.twixvj.pokemonvktest.presentation.info.components.PokemonInfoContent

@Composable
fun PokemonInfoScreen(
    name: String,
    onPressBack: () -> Unit,
) {
    val viewModel = hiltViewModel<PokemonInfoViewModel>()
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onSecondaryContainer)
            .padding(12.dp),
    ) {
        val lifecycleOwner = LocalLifecycleOwner.current
        LaunchedEffect(key1 = lifecycleOwner) {
            if (lifecycleOwner.lifecycle.currentState == Lifecycle.State.STARTED) {
                viewModel.submitAction(PokemonInfoAction.Init(name = name))
            }
        }

        BackPressButton(onBackPressed = onPressBack)

        when (state) {
            PokemonInfoViewState.Loading -> {
                ProgressBar()
            }

            is PokemonInfoViewState.Result -> {
                (state as PokemonInfoViewState.Result).result?.let {
                    PokemonInfoContent(info = it)
                }
            }

            is PokemonInfoViewState.Error -> {
                ErrorDialog(text = (state as PokemonInfoViewState.Error).error)
            }
        }
    }
}
