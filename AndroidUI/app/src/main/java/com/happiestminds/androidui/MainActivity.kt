package com.happiestminds.androidui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var loginButton : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // views are now created and drawn on screen by viewManager

        loginButton = findViewById(R.id.loginB)

        loginButton.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        Log.d("MainActivity", "Button Clicked")
        // launch AuthActivity
        val authIntent = Intent(this, AuthActivity().javaClass)
        startActivity(authIntent)
    }

    fun registerClick(view: View) {
        // launch register activity
    }
}