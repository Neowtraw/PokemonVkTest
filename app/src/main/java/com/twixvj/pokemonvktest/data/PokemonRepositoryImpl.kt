package com.twixvj.pokemonvktest.data

import com.twixvj.pokemonvktest.data.mappers.PokemonInfoMapper
import com.twixvj.pokemonvktest.data.mappers.PokemonMapper
import com.twixvj.pokemonvktest.domain.PokemonRepository
import com.twixvj.pokemonvktest.domain.model.Pokemon
import com.twixvj.pokemonvktest.domain.model.PokemonInfo
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi,
    private val pokemonMapper: PokemonMapper,
    private val pokemonInfoMapper: PokemonInfoMapper,
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
            val data = pokemonInfoMapper.toPokemonInfo(api.getPokemonInfo(name = name))
            Result.success(data)
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Result.failure(e)
        }
    }
}
