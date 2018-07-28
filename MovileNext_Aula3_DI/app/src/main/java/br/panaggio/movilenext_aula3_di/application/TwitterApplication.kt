package br.panaggio.movilenext_aula3_di.application

import br.panaggio.movilenext_aula3_di.dependecies.Streaming
import br.panaggio.movilenext_aula3_di.dependecies.Timeline
import br.panaggio.movilenext_aula3_di.dependecies.Twitter
import javax.inject.Inject

class TwitterApplication /*@Inject constructor(
        private val tweeter: Tweeter,
        private val timeline: Timeline) */{

    @Inject lateinit var twetter: Twitter
    @Inject lateinit var timeline: Timeline


    @Inject
    fun enableStreaming(streaming: Streaming) {
        streaming.register(this)
    }
}