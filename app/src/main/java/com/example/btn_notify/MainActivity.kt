package com.example.btn_notify

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ServiceCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = Intent(this, NotifyService::class.java)
        val musicButton = findViewById<MaterialButton>(R.id.musicButton)
        val musicButton1 = findViewById<MaterialButton>(R.id.musicButton1)
        val musicButton2 = findViewById<MaterialButton>(R.id.musicButton2)
        val musicButton3 = findViewById<MaterialButton>(R.id.musicButton3)
        val stopButton = findViewById<MaterialButton>(R.id.stopButton)

//        val channel = NotificationChannel(
//            "btn_notify",
//            "Music Notification",
//            NotificationManager.IMPORTANCE_LOW
//        )
//
//        val manager = getSystemService(NotificationManager::class.java)
//        manager.createNotificationChannel(channel)

        musicButton.setOnClickListener {
            intent.putExtra("music", "Jazz Music is Playing")
            ContextCompat.startForegroundService(this, intent)
        }
        musicButton1.setOnClickListener {
            intent.putExtra("music", "Rock Music is Playing")
            startService(intent)
        }
        musicButton2.setOnClickListener {
            intent.putExtra("music", "Tamil Music is Playing")
            startService(intent)
        }
        musicButton3.setOnClickListener {
            intent.putExtra("music", "English Music is Playing")
            startService(intent)
        }
        stopButton.setOnClickListener {
            intent.putExtra("music", "STOP_SERVICE")
            startService(intent)
        }
    }
}

