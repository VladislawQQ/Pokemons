package com.application.pokemons.ui.adapter.diffUtil

import androidx.recyclerview.widget.DiffUtil
import com.application.pokemons.models.PokemonModel

class DiffUtil : DiffUtil.ItemCallback<PokemonModel>() {

    override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel):
            Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel):
            Boolean = oldItem.id == newItem.id
}