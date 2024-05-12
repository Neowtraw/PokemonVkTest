package com.twixvj.pokemonvktest.presentation.info.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.twixvj.pokemonvktest.domain.model.PokemonInfo
import com.twixvj.pokemonvktest.domain.model.Stat
import com.twixvj.pokemonvktest.presentation.theme.PokemonVkTestTheme

@Composable
fun PokemonInfoContent(
    modifier: Modifier = Modifier,
    info: PokemonInfo,
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
            modifier = Modifier.size(200.dp).align(Alignment.CenterHorizontally),
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
            info = PokemonInfo(
                number = "1",
                name = "Ditto",
                height = 100,
                weight = 1343,
                stats = listOf(Stat("hp", 100)),
                image = "",
            ),
        )
    }
}
