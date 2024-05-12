package com.twixvj.pokemonvktest.presentation.mappers

import com.twixvj.pokemonvktest.domain.model.PokemonInfo
import com.twixvj.pokemonvktest.presentation.models.UiPokemonInfo
import kotlinx.collections.immutable.toImmutableList
import javax.inject.Inject

class UiPokemonInfoMapper @Inject constructor(
    private val statMapper: UiStatMapper,
) {
    fun toUiPokemonInfo(model: PokemonInfo) =
        UiPokemonInfo(
            number = model.number,
            name = model.name,
            height = model.height,
            weight = model.weight,
            stats = model.stats.map(statMapper::toUiStat).toImmutableList(),
            image = model.image,
        )
}
