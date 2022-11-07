package com.happiestminds.servicedemo

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private val reciever = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // register Broadcast receiver
        val filter = IntentFilter(Intent.ACTION_USER_PRESENT)
        registerReceiver(reciever, filter)


        requestPermissions(arrayOf(Manifest.permission.CALL_PHONE), 1)

//        supportFragmentManager.
//        beginTransaction().
//        replace(R.id.parentL, StudentFragment())
//            .commit()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode){
            1 -> {
                if (grantResults[0] == RESULT_OK){
                    Toast.makeText(this, "Granted", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this, "Not Granted", Toast.LENGTH_LONG).show()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(reciever)
    }

    fun startClick(view: View) {
        // start service

        val serviceIntent = Intent(this, MyService::class.java)
            //MyService().javaClass)
        serviceIntent.putExtra("imageName", "tiger.jpg")
        serviceIntent.putExtra("url", "http://google.com")

        startService(serviceIntent)
        Toast.makeText(this, "Service Started..", Toast.LENGTH_LONG).show()
    }
    fun stopClick(view: View) {
        // stop service
        val serviceIntent = Intent(this, MyService::class.java)
        stopService(serviceIntent)

        Toast.makeText(this, "Service Stopped..", Toast.LENGTH_LONG).show()
    }
}