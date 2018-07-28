package br.panaggio.movilenext_aula2_pushnotification.fcm

import android.util.Log
import br.panaggio.movilenext_aula2_pushnotification.notification.NotificationCreation
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String?) {
        Log.d("NEW_TOKEN", token)

        FirebaseMessaging.getInstance().subscribeToTopic("MAIN")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val notification = remoteMessage.notification

        Log.d(TAG, "FCM Message ID: ${remoteMessage.messageId}")
        Log.d(TAG, "FCM Data Message: ${remoteMessage.data}")
        Log.d(TAG, "FCM Notification Message: $notification")

        notification?.let {
            val title = it.title ?: "Default title"
            val body = it.body ?: "Default body"
            val data = remoteMessage.data

            Log.d(TAG, "FCM Notification Title: $title")
            Log.d(TAG, "FCM Notification Body: $body")
            Log.d(TAG, "FCM Notification Data: $data")

            NotificationCreation.create(this, title, body)
        }
    }

    companion object {
        private val TAG = "FMService"
    }
}