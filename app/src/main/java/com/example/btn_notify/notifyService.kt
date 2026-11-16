package com.example.btn_notify

import android.Manifest
import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageManager
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_DATA_SYNC
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.ServiceCompat

class NotifyService : Service() {

    var message:String? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()

        NotificationChannel(
            "btn_notify",
            "Music Notification",
            NotificationManager.IMPORTANCE_HIGH
        )
        //getSystemService(NotificationManager::class.java).createNotificationChannel(channel)

        Log.d("NotifyService", "onCreate called")
    }


    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        message = intent?.getStringExtra("music")
        when(message) {
            "STOP_SERVICE" -> {
                stopSelf()
            }
            else -> {

                startForeground(1, createNotification())


                NotificationManagerCompat.from(this).notify(1, createNotification())

                Log.d("NotifyService", "onStartCommand called")
            }
        }

        return START_NOT_STICKY
    }

    fun createNotification(): Notification {
        return NotificationCompat.Builder(this, "btn_notify")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Music Notification")
            .setContentText(message)
            .setOnlyAlertOnce(true)
            .setOngoing(true)
            .build()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("NotifyService", "onDestroy called")
    }


}

