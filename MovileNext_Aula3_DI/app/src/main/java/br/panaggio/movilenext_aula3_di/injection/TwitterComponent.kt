package br.panaggio.movilenext_aula3_di.injection

import br.panaggio.movilenext_aula3_di.dependecies.Timeline
import br.panaggio.movilenext_aula3_di.dependecies.Twitter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, TwitterModule::class])
interface TwitterComponent {
    fun tweeter() : Twitter
    fun timeline() : Timeline
}