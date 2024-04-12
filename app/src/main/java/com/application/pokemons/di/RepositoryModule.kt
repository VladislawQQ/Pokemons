package com.application.pokemons.di

import com.application.pokemons.pagination.PokemonsPagingRepository
import com.application.pokemons.pagination.RetrofitPokemonsPagingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPagingRepository(
        repository : RetrofitPokemonsPagingRepository
    ) : PokemonsPagingRepository
}