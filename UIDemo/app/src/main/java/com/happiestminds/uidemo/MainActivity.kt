package com.happiestminds.uidemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Timer task executed on background thread
        Timer().schedule(10_000) {
            runOnUiThread {
                val i = Intent(this@MainActivity, MenuDemoActivity().javaClass)
                startActivity(i)
            }

        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add("Exit")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        finish()
        return super.onOptionsItemSelected(item)
    }

    fun continueClick(view: View) {
        Toast.makeText(this, "Continuing...",
            Toast.LENGTH_LONG).show()

        val menuDemoIntent = Intent(this, MenuDemoActivity().javaClass)
        startActivity(menuDemoIntent)
    }
}