package com.application.pokemons.pagination

import androidx.paging.PagingData
import com.application.pokemons.models.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokemonsPagingRepository {

    /**
     * Get the paging list of users.
     */
    fun getPagedUsers(): Flow<PagingData<PokemonModel>>

}