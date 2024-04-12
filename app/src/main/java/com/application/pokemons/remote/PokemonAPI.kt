package com.application.pokemons.remote

import com.application.pokemons.remote.dto.PokemonDto
import com.application.pokemons.remote.dto.PokemonsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {

    @GET("api/v2/pokemon/{pokemonName}")
    suspend fun getPokemonByName(
        @Path("pokemonName") pokemonName : String
    ) : PokemonDto

    @GET("api/v2/pokemon")
    suspend fun getPokemons(
        @Query("limit") limitCount : Int,
        @Query("offset") offsetCount : Int
    ) : PokemonsDto

    companion object {
        const val BASE_URL = "https://pokeapi.co/"
    }
}