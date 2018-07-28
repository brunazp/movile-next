package br.panaggio.notificationcreator

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat

class AppNotificationManager {

    private fun createNotificationChannel(context: Context) {
        if (notificationManager == null) {
            notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }

        val notificationChannelName = context.getString(R.string.channel)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationImportance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, notificationChannelName, notificationImportance)
            notificationManager?.createNotificationChannel(channel)
        }
    }

    fun createAndShowNotification(
            context: Context,
            title: String,
            body: String,
            includeActions: Boolean = false) {
        createNotificationChannel(context)

        val intent = Intent(context, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentText(body)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setOnlyAlertOnce(true)
                .setStyle(NotificationCompat
                        .BigTextStyle()
                        .bigText(body))

        if (includeActions) {
            val intentNotificationAction = Intent(context, NotificationDetailsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            val pendingIntentNotificationAction =
                    PendingIntent.getActivity(context, 0, intentNotificationAction, 0)

            builder.addAction(
                    R.drawable.ic_open,
                    context.getString(R.string.open),
                    pendingIntentNotificationAction);
        }

        notificationManager?.notify(NOTIFY_ID, builder.build())
    }

    companion object {
        private const val CHANNEL_ID = "Default"
        private const val NOTIFY_ID = 1000
        private var notificationManager: NotificationManager? = null
    }
}