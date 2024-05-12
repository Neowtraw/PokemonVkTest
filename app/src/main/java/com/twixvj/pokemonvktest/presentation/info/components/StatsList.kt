package com.twixvj.pokemonvktest.presentation.info.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.twixvj.pokemonvktest.domain.model.Stat

@Composable
fun StatsList(stats: List<Stat>) {
    LazyColumn {
        items(stats, key = Stat::name) { stat ->
            StatView(stat)
        }
    }
}
