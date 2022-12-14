package com.example.androidprhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnGoToActivity4 = findViewById<Button>(R.id.btnGoToActivity4)
        btnGoToActivity4.setOnClickListener {
            startActivity(Intent(this, MainActivity4::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY))
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
    }
