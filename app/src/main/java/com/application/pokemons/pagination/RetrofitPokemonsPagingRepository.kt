package com.application.pokemons.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.application.pokemons.di.IoDispatcher
import com.application.pokemons.models.PokemonModel
import com.application.pokemons.remote.PokemonAPI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetrofitPokemonsPagingRepository @Inject constructor(
    private val api: PokemonAPI,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : PokemonsPagingRepository {

    override fun getPagedUsers(): Flow<PagingData<PokemonModel>> {
        val loader: PokemonsPageLoader = { pageIndex, pageSize ->
            getPokemonsList(pageIndex, pageSize)
        }

        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PokemonsPagingSource(loader, PAGE_SIZE) }
        ).flow
    }

    private suspend fun getPokemonsList(pageIndex: Int, pageSize: Int): List<PokemonModel> =
        withContext(ioDispatcher) {
            // calculate offset value required by DAO
            val offset = pageIndex * pageSize

            // get page
            val list = api.getPokemons(pageSize, offset)

            val pokemonsList = emptyList<PokemonModel>().toMutableList()

            list.results.forEach { resultDto ->
                try {
                    val pokemon = api.getPokemonByName(resultDto.name)
                    pokemonsList.add(pokemon.toPokemon())
                } catch (_: Exception) {
                }
            }

            return@withContext pokemonsList
        }

    private companion object {
        const val PAGE_SIZE = 10
    }
}