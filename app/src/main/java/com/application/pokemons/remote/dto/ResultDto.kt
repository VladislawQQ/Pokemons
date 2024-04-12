package com.application.pokemons.remote.dto

import com.application.pokemons.models.Result

data class ResultDto(
    val name: String,
    val url: String
) {
    fun toResult() : Result {
        return Result(
            name = name,
            url = url
        )
    }
}
