package com.happiestminds.datastoragedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    lateinit var unameE : EditText
    lateinit var passE : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        unameE = findViewById(R.id.usernameE)
        passE = findViewById(R.id.passE)
    }

    fun submitClick(view: View) {
        // get credentials from edittext and store in sharedpreference
        val username = unameE.text.toString()
        val password = passE.text.toString()

       when {
           username.isEmpty() -> unameE.error = "Provide Username"
           password.isEmpty() -> passE.error = "Provide Password"
           password.length < 8 -> passE.error = "Password should be atleast 8 chars"
           else -> {
               // save it
               val pref = getSharedPreferences("credentials", MODE_PRIVATE)
               val editor = pref.edit()
               editor.putString("userid", username)
               editor.putString("password", password)
               editor.commit()

               Toast.makeText(this, "Credentials Saved: $username, $password",
                   Toast.LENGTH_LONG).show()
           }
       }


    }
}