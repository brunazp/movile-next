package br.panaggio.movilenext_aula2_kotlin.network

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryRetriever {
    private var service: GitHubService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(GIT_HUB_BASE_API)
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build()

        service = retrofit.create(GitHubService::class.java)
    }

    fun getLanguagesRepositories(callback: Callback<GitHubReposResult>, query: String) {
        val call = service.searchRepos("language:$query")
        call.enqueue(callback)
    }

    companion object {
        const val GIT_HUB_BASE_API = "https://api.github.com/"
    }
}