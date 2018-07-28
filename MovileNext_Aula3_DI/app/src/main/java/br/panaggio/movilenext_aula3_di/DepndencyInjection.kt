package br.panaggio.movilenext_aula3_di

class Tweeter(
        val api: TwitterApi,
        val user: String) {

    fun tweet(tweet: String) {
        api.postTweet(user, tweet)
    }
}

class TwitterApi(val client: OkHttpClient) {

    fun postTweet(user: String, tweet: String) {
        //val request = Request.Builder.build()
        //client.newCall(request).execute()
    }
}

class Timeline(
        val api: TwitterApi,
        val user: String) {
    private val cache: List<Tweet> = emptyList()

    fun get() = cache

    fun loadMore(amount: Int) {

    }
}

class Tweet

class OkHttpClient


fun execute() {
    val client = OkHttpClient()
    val twitterApi = TwitterApi(client)
    val user = "Bruna Panaggio"

    val tweeter = Tweeter(twitterApi, user)
    tweeter.tweet("Oi")

    val timeline = Timeline(twitterApi, user)
    timeline.loadMore(20)
    for (tweet in timeline.get()) {
        println(tweet)
    }
}