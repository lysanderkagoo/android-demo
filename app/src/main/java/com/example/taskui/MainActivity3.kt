package com.example.taskui
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ViewFlipper
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText


class MainActivity3 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)


        val txtMsg = findViewById<TextView>(R.id.textMsg)
        val message = intent.getStringExtra("message")
        val back = findViewById<Button>(R.id.backButton)
        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        val images = intArrayOf(R.drawable.image, R.drawable.img2, R.drawable.img3)
        for (imageRes in images) {
            val imageView = ImageView(this)
            imageView.setImageResource(imageRes)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            viewFlipper.addView(imageView)
        }

        back.setOnClickListener {
            finish()
        }

        txtMsg.text = message ?: "No message received"






    }
}