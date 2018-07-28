package br.panaggio.movilenext_aula3_gameinfo.ui.gameinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.panaggio.movilenext_aula3_gameinfo.R
import br.panaggio.movilenext_aula3_gameinfo.databinding.ActivityGameInfoBinding
import br.panaggio.movilenext_aula3_gameinfo.model.Game
import br.panaggio.movilenext_aula3_gameinfo.utils.contentView
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
    }

    companion object {
        const val GAME_URL= "https://goo.gl/jzjMBc"
    }
}