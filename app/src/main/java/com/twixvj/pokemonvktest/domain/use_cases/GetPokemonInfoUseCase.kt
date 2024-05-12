package com.twixvj.pokemonvktest.domain.use_cases

import com.twixvj.pokemonvktest.domain.PokemonRepository
import com.twixvj.pokemonvktest.domain.model.PokemonInfo
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val repository: PokemonRepository,
) {
    suspend operator fun invoke(name: String): Result<PokemonInfo> =
        repository.getPokemonInfo(name = name)
}
