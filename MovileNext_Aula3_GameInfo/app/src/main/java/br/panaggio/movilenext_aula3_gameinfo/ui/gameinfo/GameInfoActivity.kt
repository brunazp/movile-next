package br.panaggio.movilenext_aula3_gameinfo.ui.gameinfo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.panaggio.movilenext_aula3_gameinfo.R
import br.panaggio.movilenext_aula3_gameinfo.databinding.ActivityGameInfoBinding
import br.panaggio.movilenext_aula3_gameinfo.model.Game
import br.panaggio.movilenext_aula3_gameinfo.ui.addgame.AddGameActivity
import br.panaggio.movilenext_aula3_gameinfo.utils.contentView
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_game_info.*

class GameInfoActivity : AppCompatActivity() {

    /*private val binding: ActivityGameInfoBinding by lazy {
        DataBindingUtil.setContentView<ActivityGameInfoBinding>(this, R.layout.activity_game_info)
    }*/

    val binding: ActivityGameInfoBinding by contentView(R.layout.activity_game_info)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val game = Game("Just Dance 2018", 2018, GAME_URL, 4.1)
        binding.game = game

        textViewRating.setOnClickListener {
            binding.game?.rating = 4.5
        }

        fabAdd.setOnClickListener {
            intent = Intent(this, AddGameActivity::class.java)
            startActivity(intent)
        }

    }

    fun testRx() {
        val TAG = "RxJava"

        Observable.just(1, 2, 3)
                .map { it * 2 }
                .filter { it > 4 }
                .subscribe { Log.d(TAG, "${it}") }

        /* val observable = Observable.just(1, 2, 3)

         observable.subscribe {
             Log.d(TAG, "accept $it")
         }*/

        /* val observer = object : Observer<Int> {
            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "onSubscribe")
            }

            override fun onNext(t: Int) {
                Log.d(TAG, "onNext $t")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "onError", e)
            }

        }

        observable.subscribe(observer)*/
    }

    companion object {
        const val GAME_URL = "https://goo.gl/jzjMBc"
    }
}