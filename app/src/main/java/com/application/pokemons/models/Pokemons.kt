package com.application.pokemons.models

import com.application.pokemons.models.Result

data class Pokemons(
    val count: Int,
    val result: List<Result>
)
