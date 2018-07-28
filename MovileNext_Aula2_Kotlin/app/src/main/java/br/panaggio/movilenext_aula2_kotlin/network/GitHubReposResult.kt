package br.panaggio.movilenext_aula2_kotlin.network

import com.google.gson.annotations.SerializedName

data class GitHubReposResult(
        @SerializedName(value = "items") val repos: List<Repository>
)

data class Repository(
        val id: Long?,
        val name: String?,
        @SerializedName("full_name") val fullName: String?,
        val owner: Owner?,
        val private: Boolean,
        @SerializedName("html_url") val htmlUrl: String?,
        val description: String?
)

data class Owner(
        val login: String?,
        val id: Long?,
        @SerializedName("avatar_url") val avatarUrl: String?
)