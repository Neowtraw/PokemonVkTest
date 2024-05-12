package com.twixvj.pokemonvktest.presentation.info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.twixvj.pokemonvktest.R
import com.twixvj.pokemonvktest.presentation.theme.PokemonVkTestTheme

@Composable
fun BackPressButton(
    onBackPressed: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .clickable(onClick = onBackPressed)
            .background(color = MaterialTheme.colorScheme.outline.copy(.2f))
            .padding(10.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_press_back),
            tint = MaterialTheme.colorScheme.onSecondary,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
private fun BackPressButtonPreview() {
    PokemonVkTestTheme {
        BackPressButton(onBackPressed = {})
    }
}
