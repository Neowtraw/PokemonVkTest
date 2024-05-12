package com.twixvj.pokemonvktest.domain.model

import androidx.annotation.DrawableRes
import com.twixvj.pokemonvktest.R

data class Stat(
    val name: String,
    val value: Int,
) {
    val formattedName: String get() = when(name) {
        "hp" -> "HP"
        "attack" -> "Attack"
        "defense" -> "Defense"
        "special-attack" -> "Sp. Atk"
        "special-defense" -> "Sp. Dep"
        "speed" -> "Speed"
        else -> name
    }

    @DrawableRes val formattedIcon: Int = when(name) {
        "hp" -> R.drawable.ic_hp
        "attack", "special-attack" -> R.drawable.ic_attack
        "defense", "special-defense" -> R.drawable.ic_defense
        "speed" -> R.drawable.ic_speed
        else -> R.drawable.img_error
    }
}
