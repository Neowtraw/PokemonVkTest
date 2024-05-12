package com.twixvj.pokemonvktest.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.twixvj.pokemonvktest.presentation.models.UiPokemon
import com.twixvj.pokemonvktest.presentation.theme.PokemonVkTestTheme

@Composable
fun PokemonView(
    modifier: Modifier = Modifier,
    pokemon: UiPokemon,
    onPokemonSelected: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .clickable(onClick = onPokemonSelected)
            .background(color = MaterialTheme.colorScheme.onSecondary)
            .padding(vertical = 10.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.Top,
    ) {
        AsyncImage(
            modifier = Modifier.size(70.dp),
            model = pokemon.image,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = pokemon.name.replaceFirstChar(Char::uppercase),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.alpha(.8f),
            fontWeight = FontWeight.Bold,
        )

        Spacer(Modifier.weight(1f))

        Text(
            text = pokemon.number,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.alpha(.4f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PokemonViewPreview() {
    PokemonVkTestTheme {
        PokemonView(
            pokemon = UiPokemon("Tiddo", "123", "123"),
            onPokemonSelected = {},
        )
    }
}
