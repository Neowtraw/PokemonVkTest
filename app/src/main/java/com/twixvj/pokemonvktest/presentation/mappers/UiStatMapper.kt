package com.twixvj.pokemonvktest.presentation.mappers

import com.twixvj.pokemonvktest.R
import com.twixvj.pokemonvktest.domain.model.Stat
import com.twixvj.pokemonvktest.presentation.models.UiStat
import javax.inject.Inject

class UiStatMapper @Inject constructor() {
    fun toUiStat(model: Stat) =
        UiStat(
            name = when (model.name) {
                "hp" -> "HP"
                "attack" -> "Attack"
                "defense" -> "Defense"
                "special-attack" -> "Sp. Atk"
                "special-defense" -> "Sp. Dep"
                "speed" -> "Speed"
                else -> model.name
            },
            value = model.value,
            icon = when (model.name) {
                "hp" -> R.drawable.ic_hp
                "attack", "special-attack" -> R.drawable.ic_attack
                "defense", "special-defense" -> R.drawable.ic_defense
                "speed" -> R.drawable.ic_speed
                else -> R.drawable.img_error
            },
        )
}
