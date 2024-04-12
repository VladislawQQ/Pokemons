package com.application.pokemons.remote.dto

import com.application.pokemons.models.Stat

data class StatDto(
    val name : String
) {
    fun toStat() : Stat {
        return Stat(
            name = name
        )
    }
}