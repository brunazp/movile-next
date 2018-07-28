package br.panaggio.movilenext_aula3_gameinfo.ui.addgame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import br.panaggio.movilenext_aula3_gameinfo.R
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Flowables
import kotlinx.android.synthetic.main.activity_add_game.*
import java.util.concurrent.TimeUnit

class AddGameActivity : AppCompatActivity() {

    private lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_game)

        val nameChangeObservable = RxTextView
                .textChanges(etName)
                .skip(1)
                .debounce(800, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.LATEST)

        val yearChangeObservable = RxTextView
                .textChanges(etYear)
                .skip(1)
                .debounce(800, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .toFlowable(BackpressureStrategy.LATEST)

        disposable = Flowables.combineLatest(nameChangeObservable, yearChangeObservable) { newName: CharSequence, newYear: CharSequence ->
            val isValidName = newName.length > 4
            if (!isValidName) {
                etName.error = "Invalid Name"
            }

            val isValidYear = newYear.length == 4
            if (!isValidYear) {
                etYear.error = "Invalid Year"
            }

            isValidName && isValidYear
        }.subscribe { isFormValid ->
            val color = ContextCompat.getColor(applicationContext, if (isFormValid) R.color.colorPrimary else android.R.color.darker_gray)
            btAdd.setBackgroundColor(color)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}
