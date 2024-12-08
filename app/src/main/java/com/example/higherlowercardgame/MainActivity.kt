package com.example.higherlowercardgame

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.startButton)
        button1.setOnClickListener{
            val intent1 = Intent(this, GameActivity::class.java)
            startActivity(intent1)
        }

        val button2 = findViewById<Button>(R.id.rulesButton)
        button2.setOnClickListener{
            val intent2 = Intent(this, RulesActivity::class.java)
            startActivity(intent2)
        }

    }
}