package com.happiestminds.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast


class MainActivity : AppCompatActivity() {

     private val TAG = "MainActivity"

    // DO NOT execute manually
    // executed by ActivityManager, once for a activity instance
    // super execution mandatory for all life-cycle methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate executed..")
    }

    override fun onStart() {
        //TODO - reload data
        backCount = 0
        super.onStart()
        Log.d(TAG, "onStart executed..")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume executed..")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause executed..")
    }

    override fun onStop() {
        //TODO - Save data of activity
        super.onStop()
        Log.d(TAG, "onStop executed..")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy executed...")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart executed..")
    }

    var backCount = 0
    override fun onBackPressed() {
        backCount++

        if (backCount == 2) {
            //backCount = 0
            super.onBackPressed() // activity is invisible
        }else {
            Toast.makeText(this,
                "Pls press 'Back' again to exit",
                Toast.LENGTH_LONG ).show()
        }
    }

}