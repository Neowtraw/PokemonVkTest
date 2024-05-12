package com.twixvj.pokemonvktest.domain

import com.twixvj.pokemonvktest.domain.model.Pokemon
import com.twixvj.pokemonvktest.domain.model.PokemonInfo

interface PokemonRepository {
    suspend fun getAllPokemons(): Result<List<Pokemon>>

    suspend fun getPokemonInfo(name: String): Result<PokemonInfo>
}
