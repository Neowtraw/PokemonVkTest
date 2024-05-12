package com.twixvj.pokemonvktest.data.mappers

import com.twixvj.pokemonvktest.data.model.PokemonInfoResponse
import com.twixvj.pokemonvktest.data.model.PokemonModel
import com.twixvj.pokemonvktest.data.model.StatsResponse
import com.twixvj.pokemonvktest.domain.model.Pokemon
import com.twixvj.pokemonvktest.domain.model.PokemonInfo
import com.twixvj.pokemonvktest.domain.model.Stat
import javax.inject.Inject

class PokemonMapper @Inject constructor() {
    fun toPokemon(model: PokemonModel): Pokemon =
        Pokemon(
            name = model.name,
            image = model.imageUrl,
            number = model.numberString,
        )

    fun toPokemonInfo(model: PokemonInfoResponse): PokemonInfo =
        PokemonInfo(
            number = model.idString,
            name = model.name,
            height = model.height,
            weight = model.weight,
            stats = model.stats.map(::toStat),
            image = model.image,
        )

    private fun toStat(model: StatsResponse): Stat = Stat(
        name = model.stat.name,
        value = model.value,
    )
}
