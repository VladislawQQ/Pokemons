package com.application.pokemons.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.application.pokemons.databinding.ItemPokemonBinding
import com.application.pokemons.models.PokemonModel
import com.application.pokemons.ui.adapter.diffUtil.DiffUtil
import com.application.pokemons.ui.setPokemonPhoto

class PokemonInfoAdapter : PagingDataAdapter<PokemonModel, PokemonInfoAdapter.PokemonViewHolder>(
    DiffUtil()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemPokemonBinding.inflate(inflater, parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position) ?: return)
    }


    inner class PokemonViewHolder(
        private val binding: ItemPokemonBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pokemon: PokemonModel) {
            with(binding) {
                imageViewPokemonImage.setPokemonPhoto(pokemon.sprites.front_default)
                textViewPokemonName.text = pokemon.name
                textViewHp.text = pokemon.stats[0].base_stat.toString()
                textViewAttack.text = pokemon.stats[1].base_stat.toString()
                textViewDefence.text = pokemon.stats[2].base_stat.toString()
                textViewSpecialAttack.text = pokemon.stats[3].base_stat.toString()
                textViewSpecialDefence.text = pokemon.stats[4].base_stat.toString()
                textViewSpeed.text = pokemon.stats[5].base_stat.toString()
            }
        }
    }
}