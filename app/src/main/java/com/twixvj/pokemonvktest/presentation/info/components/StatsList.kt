package com.twixvj.pokemonvktest.presentation.info.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.twixvj.pokemonvktest.presentation.models.UiStat
import kotlinx.collections.immutable.ImmutableList

@Composable
fun StatsList(
    modifier: Modifier = Modifier,
    stats: ImmutableList<UiStat>,
) {
    LazyColumn(modifier = modifier) {
        items(stats.size, key = {stats[it].name}) { index ->
            StatView(stat = stats[index])
        }
    }
}
