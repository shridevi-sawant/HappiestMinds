package com.happiestminds.intentsdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameE)
        emailEditText = findViewById(R.id.emailE)
    }

    fun submitClick(view: View) {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()

        if (name.isEmpty()){
            nameEditText.error = "Name is Mandatory"
        }
        if (email.isEmpty()) {
            emailEditText.error = "Email is mandatory"
        }

        if (email.isNotEmpty() && name.isNotEmpty()){
            // launch next activity
            val anotherIntent = Intent(this,
                AnotherActivity().javaClass)
            anotherIntent.putExtra("username", name)
            anotherIntent.putExtra("useremail", email)
            startActivity(anotherIntent)
        }
    }
}