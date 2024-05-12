package com.twixvj.pokemonvktest.presentation.info.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.twixvj.pokemonvktest.R
import com.twixvj.pokemonvktest.presentation.models.UiPokemonInfo
import com.twixvj.pokemonvktest.presentation.models.UiStat
import com.twixvj.pokemonvktest.presentation.theme.PokemonVkTestTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun MeasureInfo(
    modifier: Modifier = Modifier,
    info: UiPokemonInfo,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colorScheme.outline.copy(.2f))
            .padding(horizontal = 12.dp, vertical = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary,
                )
                Spacer(Modifier.width(4.dp))

                val weightInKg = info.weight / 10f

                Text(
                    text = "$weightInKg kg",
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                )
            }

            Spacer(Modifier.height(4.dp))

            Text(
                text = stringResource(id = R.string.weight),
                color = MaterialTheme.colorScheme.onSecondary.copy(.8f),
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        VerticalDivider(
            modifier = Modifier.height(30.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline,
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary,
                )
                Spacer(Modifier.width(4.dp))

                val heightInMeter = info.height / 10f

                Text(
                    text = "$heightInMeter m",
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                )
            }

            Spacer(Modifier.height(4.dp))

            Text(
                text = stringResource(id = R.string.height),
                color = MaterialTheme.colorScheme.onSecondary.copy(.8f),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview
@Composable
private fun MeasureInfoPreview() {
    PokemonVkTestTheme {
        MeasureInfo(
            info = UiPokemonInfo(
                number = "1",
                name = "Ditto",
                height = 100,
                weight = 1343,
                stats = persistentListOf(UiStat("hp", 100, R.drawable.ic_hp)),
                image = "",
            ),
        )
    }
}
