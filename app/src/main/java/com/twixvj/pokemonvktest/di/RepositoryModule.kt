package com.twixvj.pokemonvktest.di

import com.twixvj.pokemonvktest.data.PokemonRepositoryImpl
import com.twixvj.pokemonvktest.domain.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    @Singleton
    fun getPokemonRepository(repository: PokemonRepositoryImpl): PokemonRepository
}
