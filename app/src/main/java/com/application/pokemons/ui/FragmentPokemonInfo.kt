package com.application.pokemons.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.pokemons.databinding.FragmentPokemonInfoBinding
import com.application.pokemons.ui.adapter.PokemonInfoAdapter
import com.application.pokemons.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentPokemonInfo : BaseFragment<FragmentPokemonInfoBinding>(FragmentPokemonInfoBinding::inflate) {

    private val viewModel : PokemonInfoViewModel by viewModels()
    private val pokemonInfoAdapter : PokemonInfoAdapter = PokemonInfoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerLayoutManager = LinearLayoutManager(activity)

        with(binding.recyclerViewPokemonList) {
            layoutManager = recyclerLayoutManager
            adapter = pokemonInfoAdapter
        }

        setObserver()
    }

    private fun setObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.usersFlow.collect { pokemon ->
                    pokemonInfoAdapter.submitData(pokemon)
                }
            }
        }
    }

}