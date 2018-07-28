package br.panaggio.movilenext_aula3_gameinfo.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import br.panaggio.movilenext_aula3_gameinfo.utils.bindable
import com.android.databinding.library.baseAdapters.BR

class Game(
        name: String,
        val launchYear: Int,
        val imageUrl: String,
        rating: Double) : BaseObservable() {

    val isClassic = launchYear < 2000

    /*var rating = rating
        @Bindable get
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.rating)
            }
        }*/

    @get:Bindable
    var name by bindable(name, BR.name)

    @get:Bindable
    var rating by bindable(rating, BR.rating)
}