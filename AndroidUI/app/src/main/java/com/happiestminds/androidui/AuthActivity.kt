package com.happiestminds.androidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AuthActivity : AppCompatActivity() {

    private lateinit var useridEditText : EditText
    private lateinit var passEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        useridEditText = findViewById(R.id.useridE)
        passEditText = findViewById(R.id.passE)

        val submitButton = findViewById<Button>(R.id.submitB)

        // annonymous interface implementation
        submitButton.setOnClickListener {
            Log.d("AuthActivity","Submit clicked..")
            val userid = useridEditText.text.toString()
            val password = passEditText.text.toString()

            Log.d("AuthActivity", "USerid: $userid, password: $password")

            if (userid.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "You entered userid: $userid, password: $password",
                    Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this, "Pls enter all data",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    fun cancelClick(view: View) {
        Log.d("AuthActivity", "Cancel clicked..")
        useridEditText.setText("")
        passEditText.setText("")
        finish() // closes activity
    }
}