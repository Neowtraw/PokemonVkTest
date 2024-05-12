package com.twixvj.pokemonvktest.domain.use_cases

import com.twixvj.pokemonvktest.domain.PokemonRepository
import com.twixvj.pokemonvktest.domain.model.Pokemon
import javax.inject.Inject

class GetAllPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository,
) {
    suspend operator fun invoke(): Result<List<Pokemon>> =
        repository.getAllPokemons()
}
