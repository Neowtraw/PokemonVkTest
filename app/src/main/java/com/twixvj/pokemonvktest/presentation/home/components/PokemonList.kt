package com.twixvj.pokemonvktest.presentation.home.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.twixvj.pokemonvktest.domain.model.Pokemon

@Composable
fun PokemonList(
    pokemons: List<Pokemon>,
    onPokemonSelected: (String) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(pokemons, key = Pokemon::name) { pokemon ->
            Log.d("pokemon", pokemon.name)
            PokemonView(
                pokemon = pokemon,
                onPokemonSelected = {
                    onPokemonSelected(pokemon.name)
                },
            )
        }
    }
}
