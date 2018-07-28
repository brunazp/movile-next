package br.panaggio.movilenext_aula3_di.injection


import br.panaggio.movilenext_aula3_di.dependecies.TwitterApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides @Singleton
    fun provideOkHttpClient() = OkHttpClient()

    /*@Provides @Singleton
    fun provideTwitterApi(client: OkHttpClient) = TwitterApi(client)*/
}