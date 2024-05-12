package com.twixvj.pokemonvktest.data

import android.util.Log
import com.twixvj.pokemonvktest.data.mappers.PokemonMapper
import com.twixvj.pokemonvktest.domain.PokemonRepository
import com.twixvj.pokemonvktest.domain.model.PokemonInfo
import com.twixvj.pokemonvktest.domain.model.Pokemon
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
    private val pokemonMapper: PokemonMapper,
) : PokemonRepository {
    override suspend fun getAllPokemons(): Result<List<Pokemon>> {
        return try {
            val data = api.getAllPokemons().results.map(pokemonMapper::toPokemon)
            Result.success(data)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(e)
        }
    }

    override suspend fun getPokemonInfo(name: String): Result<PokemonInfo> {
        return try {
            val data = pokemonMapper.toPokemonInfo(api.getPokemonInfo(name = name))
            Result.success(data)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(e)
        }
    }
}
