package com.application.pokemons.remote.dto

import com.application.pokemons.models.Sprites

data class SpritesDto(
    val front_default: String,
) {
    fun toSprites() : Sprites {
        return Sprites(
            front_default = front_default
        )
    }
}
