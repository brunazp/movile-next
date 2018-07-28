package br.panaggio.movilenext_aula3_di

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.panaggio.movilenext_aula3_di.injection.DaggerTwitterComponent
import br.panaggio.movilenext_aula3_di.injection.NetworkModule
import br.panaggio.movilenext_aula3_di.injection.TwitterModule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerTwitterComponent.builder()
                .twitterModule(TwitterModule("Bruna Panaggio"))
                .build()

        val twetter = component.tweeter()
        val module = component.timeline()
    }
}
