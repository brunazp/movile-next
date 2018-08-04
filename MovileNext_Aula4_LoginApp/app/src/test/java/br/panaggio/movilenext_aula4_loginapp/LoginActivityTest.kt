package br.panaggio.movilenext_aula4_loginapp

import android.widget.TextView
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LoginActivityTest {

    @Test
    fun loadActivitySouldShowHelloWorld() {
        val activity = Robolectric.setupActivity(LoginActivity::class.java)

        val results = activity.findViewById<TextView>(R.id.textViewStatus)
        assertThat(results.text.toString(), equalTo("Hello World!"))
    }


    @Test
    fun loadActivitySouldShowHelloWorld2() {
        val activity = Robolectric.setupActivity(LoginActivity::class.java)

        val results = activity.findViewById<TextView>(R.id.textViewStatus)
        assertThat(results.text.toString(), equalTo("Hello World!"))
    }
}