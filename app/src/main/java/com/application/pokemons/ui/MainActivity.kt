package com.application.pokemons.ui

import com.application.pokemons.databinding.ActivityMainBinding
import com.application.pokemons.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate)