package br.panaggio.movilenext_aula3_di.injection

import br.panaggio.movilenext_aula3_di.dependecies.Timeline
import br.panaggio.movilenext_aula3_di.dependecies.Twitter
import br.panaggio.movilenext_aula3_di.dependecies.TwitterApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TwitterModule(private val user: String) {

    @Provides @Singleton
    fun provideTweeter(api: TwitterApi) = Twitter(api, user)

    @Provides @Singleton
    fun provideTimeline(api: TwitterApi) = Timeline(api, user)

}