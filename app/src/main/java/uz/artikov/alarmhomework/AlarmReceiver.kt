package uz.artikov.alarmhomework

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {
    @SuppressLint("MissingPermission", "UnspecifiedImmutableFlag")
    override fun onReceive(p0: Context?, p1: Intent?) {


        val i = Intent(p0, DestinisationActivity::class.java)
        p1!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(p0, 0, i, 0)
        val builder = NotificationCompat.Builder(p0!!, "Artikov")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Fox Android Alarm Manager")
            .setContentTitle("Subcribe for more android related content").setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL).setPriority(Notification.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManagerCompat = NotificationManagerCompat.from(p0)
        notificationManagerCompat.notify(123, builder.build())

    }
}