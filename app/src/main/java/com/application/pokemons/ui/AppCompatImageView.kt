package com.application.pokemons.ui

import androidx.appcompat.widget.AppCompatImageView
import com.application.pokemons.R
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

val GLIDE_OPTIONS = RequestOptions()
    .circleCrop()
    .error(R.drawable.ic_error)
    .diskCacheStrategy(DiskCacheStrategy.ALL)
    .priority(Priority.HIGH)

fun AppCompatImageView.setPokemonPhoto(
    contactPhotoUri: String? = null
) {
    Glide.with(context)
        .load(contactPhotoUri)
        .apply(GLIDE_OPTIONS)
        .into(this)
}