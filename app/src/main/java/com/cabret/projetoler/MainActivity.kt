package com.cabret.projetoler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.btnNavegar).setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java);

            startActivity(intent);
        }
    }
}