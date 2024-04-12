package com.application.pokemons.remote.dto

import com.application.pokemons.models.Pokemons

data class PokemonsDto(
    val count: Int,
    val next: Any?,
    val previous: Any?,
    val results: List<ResultDto>
) {
    fun toPokemons() : Pokemons {
        return Pokemons(
            count = count,
            result = results.map { it.toResult() }
        )
    }
}
