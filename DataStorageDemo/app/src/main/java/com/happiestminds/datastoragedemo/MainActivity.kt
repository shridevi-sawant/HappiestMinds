package com.happiestminds.datastoragedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.button)


    }

    override fun onResume() {
        super.onResume()
        if (isUserLoggedIn())
        {
            loginButton.text = "LOGOUT"
        }
    }

    private fun isUserLoggedIn(): Boolean {
        // read from sharedPreference
        val pref = getSharedPreferences("credentials", MODE_PRIVATE)
        val username = pref.getString("userid", null)
        val password = pref.getString("password", null)

        if (username != null && password != null){
            return true
        }

        return false
    }

    fun loginClick(view: View) {
        // open authentication activity
        when (loginButton.text.toString().lowercase()){
            "login" -> {
                val authIntent = Intent(this, AuthActivity::class.java)
                startActivity(authIntent)
            }
            "logout" -> {
                // delete credentials
                val pref = getSharedPreferences("credentials", MODE_PRIVATE)
                val editor = pref.edit()
                editor.clear()
                editor.commit()
                Toast.makeText(this, "You logged out..",
                    Toast.LENGTH_LONG).show()
                loginButton.text = "LOGIN"
            }
        }


    }

    fun studentClick(view: View) {
        // open activity to show studnet list
        val stdIntent = Intent(this, StudentListActivity::class.java)
        startActivity(stdIntent)
    }

    fun addressClick(view: View) {
        val addrIntent = Intent(this, AddressActivity::class.java)
        startActivity(addrIntent)
    }
}