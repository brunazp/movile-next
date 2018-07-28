package br.panaggio.movilenext_aula2_pushnotification.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.panaggio.movilenext_aula2_pushnotification.R
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load(IMAGE_URL).into(imageViewGlide)

        Picasso.get().load(IMAGE_URL).into(imageViewPicasso);
    }

    companion object {
        const val IMAGE_URL = "http://www.cuelogic.com/blog/wp-content/uploads/2017/08/Kotlin-for-Android-development.png"
    }
}
