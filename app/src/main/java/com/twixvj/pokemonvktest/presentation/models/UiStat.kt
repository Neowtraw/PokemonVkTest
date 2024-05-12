package com.twixvj.pokemonvktest.presentation.models

import androidx.annotation.DrawableRes

data class UiStat(
    val name: String,
    val value: Int,
    @DrawableRes val icon: Int,
)
