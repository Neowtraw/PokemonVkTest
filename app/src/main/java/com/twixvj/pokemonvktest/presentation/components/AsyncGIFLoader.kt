package com.twixvj.pokemonvktest.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.request.ImageRequest

@Composable
fun AsyncGIFLoader(
    modifier: Modifier = Modifier,
    url: String,
) {
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(url)
        .decoderFactory(GifDecoder.Factory())
        .build()

    AsyncImage(
        modifier = modifier,
        model = imageRequest,
        contentDescription = null,
    )
}
