package com.application.pokemons.remote.dto

import com.application.pokemons.models.Stats

data class StatsDto(
    val base_stat : Int,
    val effort : Int,
    val stat : StatDto
) {
    fun toStats() : Stats {
        return Stats(
            base_stat = base_stat,
            effort = effort,
            stat = stat.toStat()
        )
    }
}