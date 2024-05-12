package com.twixvj.pokemonvktest.presentation.info.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.twixvj.pokemonvktest.R
import com.twixvj.pokemonvktest.presentation.models.UiPokemonInfo
import com.twixvj.pokemonvktest.presentation.models.UiStat
import com.twixvj.pokemonvktest.presentation.theme.PokemonVkTestTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun PokemonInfoContent(
    modifier: Modifier = Modifier,
    info: UiPokemonInfo,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = info.name,
            fontSize = 25.sp,
            color = MaterialTheme.colorScheme.onSecondary.copy(.8f),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
        )

        Spacer(modifier = Modifier.height(10.dp))

        AsyncImage(
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally),
            model = info.image,
            contentDescription = null,
        )

        Spacer(modifier = Modifier.height(10.dp))

        MeasureInfo(info = info)

        Spacer(modifier = Modifier.height(10.dp))

        StatsList(stats = info.stats)
    }
}

@Preview(showBackground = true)
@Composable
private fun PokemonInfoContentPreview() {
    PokemonVkTestTheme {
        PokemonInfoContent(
            info = UiPokemonInfo(
                number = "1",
                name = "Ditto",
                height = "100 m",
                weight = "11 kg",
                stats = persistentListOf(UiStat("hp", 100, R.drawable.ic_hp)),
                image = "",
            ),
        )
    }
}
