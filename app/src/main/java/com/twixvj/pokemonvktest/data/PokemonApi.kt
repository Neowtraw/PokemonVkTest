package com.twixvj.pokemonvktest.data

import com.twixvj.pokemonvktest.data.model.PokemonInfoResponse
import com.twixvj.pokemonvktest.data.model.AllPokemonsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon/")
    suspend fun getAllPokemons(
       @Query("limit") limit: Int = 100000,
       @Query("offset") offset: Int = 0,
    ): AllPokemonsResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String,
        @Query("limit") limit: Int = 100000,
        @Query("offset") offset: Int = 0,
    ): PokemonInfoResponse
}
