package com.happiestminds.receiverdemo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    val receiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // register receiver
        val intentFilter = IntentFilter("com.happiestminds.receiverdemo.action.download_complete")
        registerReceiver(receiver, intentFilter)
    }



    fun buttonClick(view: View) {
        //TODO-  Download data
        // send broadcast - event - Download completed..
        Timer().schedule(5000) {
            val broadcastIntent = Intent("com.happiestminds.receiverdemo.action.download_complete")
            broadcastIntent.putExtra("time", Calendar.getInstance().time.toString())
            sendBroadcast(broadcastIntent)
            runOnUiThread {
                Toast.makeText(this@MainActivity, "Broadcast sent",
                    Toast.LENGTH_LONG).show()
            }

        }


    }
}