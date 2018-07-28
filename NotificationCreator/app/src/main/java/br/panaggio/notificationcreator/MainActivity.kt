package br.panaggio.notificationcreator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAddNotification.setOnClickListener {
            val appNotificationManager = AppNotificationManager()
            appNotificationManager.createAndShowNotification(
                    this,
                    editTextNotificationTitle.text.toString(),
                    editTextNotificationBody.text.toString(),
                    checkBoxAddButtons.isChecked)
            reset()
        }
    }

    fun reset() {
        editTextNotificationTitle.text.clear()
        editTextNotificationBody.text.clear()
    }

}
