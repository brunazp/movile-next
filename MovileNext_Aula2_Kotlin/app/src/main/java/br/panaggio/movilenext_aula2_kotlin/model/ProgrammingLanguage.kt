package br.panaggio.movilenext_aula2_kotlin.model

import android.support.annotation.DrawableRes

data class ProgrammingLanguage(
        val name: String,
        val year: Int,
        val description: String,
        @DrawableRes val imageResourceId: Int)