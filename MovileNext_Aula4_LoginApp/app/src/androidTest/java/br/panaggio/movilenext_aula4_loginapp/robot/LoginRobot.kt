package br.panaggio.movilenext_aula4_loginapp.robot

import android.content.Context
import android.support.test.espresso.ViewInteraction
import br.panaggio.movilenext_aula4_loginapp.R

class LoginRobot(private val context: Context) : BaseTestRobot() {

    fun setEmail(email: String) = apply {
        fillEditText(R.id.editTextUsername, email)
    }

    fun setPassword(pass: String) = apply {
        fillEditText(R.id.editTextPassword, pass)
    }

    fun clickLogin() = apply {
        clickButton(R.id.buttonLogin)
    }

    fun matchErrorText(err: Int): ViewInteraction {
        return matchText(textView(android.R.id.message),
                context.getString(err))
    }
}