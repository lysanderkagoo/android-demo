package com.example.btn_notify

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
import android.util.Log
import androidx.core.app.ServiceCompat

class NotifyService : Service() {

    var message:String? = null
    lateinit var notify: Notification

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()


        val channel = NotificationChannel(
            "btn_notify",
            "Music Notification",
            NotificationManager.IMPORTANCE_HIGH
        )

        val manager = getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)

        Log.d("NotifyService", "onCreate called")
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        message = intent?.getStringExtra("music")
        when(message) {
            "STOP_SERVICE" -> {
                stopSelf()
            }
            else -> {


                val notificationManager = getSystemService(NotificationManager::class.java)
                notificationManager.notify(1, notify)

                Log.d("NotifyService", "onStartCommand called")
            }
        }

        return START_NOT_STICKY
    }

    fun createNotificationChannel() {
        val notificationManager = getSystemService(NotificationManager::class.java)  NotificationCompat.Builder(this, "btn_notify")
            .setContentTitle("Music App")
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
    }


}

