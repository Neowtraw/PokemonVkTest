package com.twixvj.pokemonvktest.data.mappers

import com.twixvj.pokemonvktest.data.model.PokemonInfoResponse
import com.twixvj.pokemonvktest.domain.model.PokemonInfo
import javax.inject.Inject

class PokemonInfoMapper @Inject constructor(
    private val statMapper: StatMapper,
) {
    fun toPokemonInfo(model: PokemonInfoResponse): PokemonInfo =
        PokemonInfo(
            number = model.idString,
            name = model.name,
            height = model.height,
            weight = model.weight,
            stats = model.stats.map(statMapper::toStat),
            image = model.image,
        )
}
