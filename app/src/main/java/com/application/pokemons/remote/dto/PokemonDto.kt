package com.application.pokemons.remote.dto

import com.application.pokemons.models.PokemonModel

data class PokemonDto(
    val id: Int,
    val base_experience: Int,
    val height: Int,
    val name: String,
    val order: Int,
    val sprites: SpritesDto,
    val stats: List<StatsDto>,
    val weight: Int
) {
    fun toPokemon() : PokemonModel {
        return PokemonModel(
            base_experience = base_experience,
            height = height,
            id = id,
            name = name,
            order = order,
            sprites = sprites.toSprites(),
            stats = stats.map { it.toStats() },
            weight = weight
        )
    }
}