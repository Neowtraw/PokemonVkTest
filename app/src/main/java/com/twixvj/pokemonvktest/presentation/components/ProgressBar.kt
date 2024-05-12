package com.twixvj.pokemonvktest.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.twixvj.pokemonvktest.presentation.theme.PokemonVkTestTheme

@Composable
fun ProgressBar() {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncGIFLoader(
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center)
                .clip(shape = CircleShape),
            url = "https://c.tenor.com/tCL3HGcaV4UAAAAd/tenor.gif",
        )
    }
}

@Preview
@Composable
private fun ProgressBarPreview() {
    PokemonVkTestTheme {
        ProgressBar()
    }
}
