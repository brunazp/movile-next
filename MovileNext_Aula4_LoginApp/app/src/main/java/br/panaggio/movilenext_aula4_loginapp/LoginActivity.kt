package br.panaggio.movilenext_aula4_loginapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener {
            val email = editTextUsername.text.toString()

            if (email == "admin@admin.com") {
                textViewStatus.text = "Bruna Panaggio"
            } else {
                textViewStatus.text = "Login Failed"
            }
        }
    }
}
