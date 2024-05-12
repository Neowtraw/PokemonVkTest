package com.twixvj.pokemonvktest.presentation.mappers

import com.twixvj.pokemonvktest.domain.model.Pokemon
import com.twixvj.pokemonvktest.presentation.models.UiPokemon
import javax.inject.Inject

class UiPokemonMapper @Inject constructor() {
    fun toUiPokemon(model: Pokemon) =
        UiPokemon(
            number = model.number,
            name = model.name,
            image = model.image,
        )
}
