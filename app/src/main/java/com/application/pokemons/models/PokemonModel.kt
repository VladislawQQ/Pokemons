package com.application.pokemons.models

data class PokemonModel(
    val id: Int,
    val base_experience: Int,
    val height: Int,
    val name: String,
    val order: Int,
    val sprites: Sprites,
    val stats: List<Stats>,
    val weight: Int
)