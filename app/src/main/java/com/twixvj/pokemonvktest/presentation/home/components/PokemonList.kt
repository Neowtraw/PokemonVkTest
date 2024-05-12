package com.twixvj.pokemonvktest.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.twixvj.pokemonvktest.presentation.models.UiPokemon
import kotlinx.collections.immutable.ImmutableList

@Composable
fun PokemonList(
    modifier: Modifier = Modifier,
    pokemons: ImmutableList<UiPokemon>,
    onPokemonSelected: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(pokemons.size, key = { pokemons[it].number }) { index ->
            PokemonView(
                pokemon = pokemons[index],
                onPokemonSelected = {
                    onPokemonSelected(pokemons[index].name)
                },
            )
        }
    }
}
