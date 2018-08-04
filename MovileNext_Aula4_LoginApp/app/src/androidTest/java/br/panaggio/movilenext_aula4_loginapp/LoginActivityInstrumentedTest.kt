package br.panaggio.movilenext_aula4_loginapp

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityInstrumentedTest {

    @get:Rule
    val rule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun loginButton_shouldWriteName() {
        //Type login on edit text
        onView(withHint(R.string.email_hint)).perform(typeText("admin@admin.com"))

        //Tap login button
        onView(withText(R.string.login)).perform(click())

        // check if textview was updated
        onView(withText("Bruna Panaggio")).check(matches(isDisplayed()))
    }
}