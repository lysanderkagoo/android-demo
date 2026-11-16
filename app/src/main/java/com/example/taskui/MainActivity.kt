package com.example.taskui
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import com.google.android.material.textfield.TextInputEditText
import android.content.Intent
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import android.provider.MediaStore
import com.google.android.material.button.MaterialButton
import androidx.core.net.toUri


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            insets
        }

        val spinner = findViewById<Spinner>(R.id.options)
        val options = arrayOf("Arun","Nesh Tech","Bala","Arshad","Vijay")
        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val text = findViewById<TextInputEditText>(R.id.textMsg)
        val sendBtn = findViewById<Button>(R.id.sendButton)

        sendBtn.setOnClickListener {
            val message = text.text.toString()
            val intent = Intent(this, MainActivity2 :: class.java)
            intent.putExtra("message",message)
            startActivity(intent)
        }
        val browserBtn = findViewById<MaterialButton>(R.id.websiteButton)
        browserBtn.setOnClickListener {
            val mainIntent = Intent(Intent.ACTION_MAIN)
            mainIntent.addCategory(Intent.CATEGORY_APP_BROWSER)
            startActivity(Intent.createChooser(mainIntent,"Open in:"))
        }
        val camBtn = findViewById<MaterialButton>(R.id.cameraButton)
        camBtn.setOnClickListener {
            val camIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(Intent.createChooser(camIntent,"Open in"))
        }
        val imgBtn = findViewById<MaterialButton>(R.id.imageButton)
        imgBtn.setOnClickListener {
            val imgIntent = Intent(Intent.ACTION_MAIN)
            imgIntent.addCategory(Intent.CATEGORY_APP_GALLERY)
            startActivity(Intent.createChooser(imgIntent,"Open in"))
        }
    }
}