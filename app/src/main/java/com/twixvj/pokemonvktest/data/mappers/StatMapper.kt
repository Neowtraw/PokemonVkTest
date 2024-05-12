package com.twixvj.pokemonvktest.data.mappers

import com.twixvj.pokemonvktest.data.model.StatsResponse
import com.twixvj.pokemonvktest.domain.model.Stat
import javax.inject.Inject

class StatMapper @Inject constructor() {
    fun toStat(model: StatsResponse): Stat = Stat(
        name = model.stat.name,
        value = model.value,
    )
}
