package com.example.praktikum2.day2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.praktikum2.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val text = intent.extras?.getString(MainActivity.EXTRA_TEXT)

        val textView: TextView = findViewById(R.id.tv_data)
        textView.text = text

        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.replace(R.id.container, MainFragment())
        fragmentManager.commit()
    }
}