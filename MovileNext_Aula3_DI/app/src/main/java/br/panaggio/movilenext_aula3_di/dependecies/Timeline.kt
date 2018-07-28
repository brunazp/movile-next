package br.panaggio.movilenext_aula3_di.dependecies

class Timeline(val api: TwitterApi, val user: String) {

    private val cache: List<Tweet> = emptyList()

    fun get() = cache

    fun loadMore(amount: Int) {

    }
}