package br.panaggio.movilenext_aula3_di.dependecies

import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TwitterApi @Inject constructor(
        val client: OkHttpClient) {

    fun postTweet(user: String, tweet: String) {
        //val request = Request.Builder.build()
        //client.newCall(request).execute()
    }
}