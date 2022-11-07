package com.happiestminds.fragmentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var loginButton: Button
    lateinit var registerButton: Button
    val loginFragment = LoginFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginButton = findViewById(R.id.loginB)
        registerButton = findViewById(R.id.registerB)

        loginButton.isEnabled = false
    }

    fun buttonClick(view: View) {
        when (view.id){
            R.id.loginB -> {

                // add LoginFragment
                val loginFragment = LoginFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.placeholderF, loginFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            R.id.registerB -> {
                val registerFragment = RegisterFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.placeholderF, registerFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
    }

    fun registerDone(){
        registerButton.isEnabled = false
        loginButton.isEnabled  = true

        // add LoginFragment
        val bundle = Bundle()
        bundle.putString("username", "demo")
        bundle.putString("password", "demo123")

        loginFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.placeholderF, loginFragment)
       // transaction.addToBackStack(null)
        transaction.commit()
    }

    fun loginDone(){
        loginButton.isEnabled = false
        val transaction = supportFragmentManager.beginTransaction()

        transaction.remove(loginFragment)

        val homeFragment = HomeFragment()
        transaction.add(R.id.placeholderF, homeFragment)
        //transaction.addToBackStack(null)
        transaction.commit()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Settings")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val settingFragment = SettingsFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.placeholderF, settingFragment)
            .addToBackStack(null)
            .commit()


        return super.onOptionsItemSelected(item)
    }

}