package com.happiestminds.testingdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var titleTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameE)
        titleTextView = findViewById(R.id.textView)
    }

    fun nextClick(view: View) {

        val name = nameEditText.text.toString()
        if (name.isNotEmpty()) {
            titleTextView.text = "Hello $name"
            nameEditText.setText("")

            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)

        }

    }
}