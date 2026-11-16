package com.example.taskui
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import android.content.Intent
import com.google.android.material.appbar.MaterialToolbar
import androidx.appcompat.widget.Toolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class MainActivity2 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener { finish()}

        val txtMsg = findViewById<TextView>(R.id.textMsg)
        val message = intent.getStringExtra("message")
        val back = findViewById<Button>(R.id.backButton)

        back.setOnClickListener {
            finish()
        }

        val next = findViewById<MaterialButton>(R.id.nextButton)
        next.setOnClickListener {
            val intent = Intent(this, MainActivity3 :: class.java)
            startActivity(intent)
        }

        txtMsg.text = message ?: "No message received"






    }
}