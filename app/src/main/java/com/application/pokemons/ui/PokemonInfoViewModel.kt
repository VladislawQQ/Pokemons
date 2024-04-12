package com.application.pokemons.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.application.pokemons.models.PokemonModel
import com.application.pokemons.pagination.PokemonsPagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PokemonInfoViewModel @Inject constructor(
    repository: PokemonsPagingRepository
) : ViewModel() {

    val usersFlow: Flow<PagingData<PokemonModel>> = repository.getPagedUsers().cachedIn(viewModelScope)

    companion object {
        const val TAG = "result"
    }

}