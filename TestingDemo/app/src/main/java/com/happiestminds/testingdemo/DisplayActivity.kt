package com.happiestminds.testingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    lateinit var nameT: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        nameT = findViewById(R.id.tv)

        val name = intent.getStringExtra("name")
        nameT.text = "Welcome $name"
    }
}