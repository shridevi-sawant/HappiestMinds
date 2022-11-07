package com.happiestminds.servicedemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.util.Timer
import kotlin.concurrent.schedule
import kotlin.concurrent.thread

class MyService : Service() {
    private val handler  = Handler()

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        // Create Thread -  if one task to be executed
        super.onCreate()
        Log.d("MyService", "OnCreate called")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "onStartCommand called")
        // Create thread - if multiple tasks to be executed parallely

        val imageName = intent?.getStringExtra("imageName")
        val imgUrl = intent?.getStringExtra("url")

        thread {
            // long running task execution
            Thread.sleep(10000)
            Log.d("MyService", "Image $imageName downloaded from $imgUrl")
            sendNotification("$imageName downloaded from $imgUrl") // task completed

//            handler.post {
//                Toast.makeText(this, "TAsk completed", Toast.LENGTH_LONG).show()
//            }

        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService", "onDestroy called")
    }


    fun sendNotification(descr: String){
        // get notification manager
        val nManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // create notification
        val channel = NotificationChannel("test", "Download",
            NotificationManager.IMPORTANCE_DEFAULT)

        nManager.createNotificationChannel(channel)

        val builder = Notification.Builder(this, "test")

        builder.setSmallIcon(R.mipmap.ic_launcher)
        builder.setContentTitle("Task Complete")
        builder.setContentText(descr)

        val i = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(this,
            1, i, PendingIntent.FLAG_IMMUTABLE)

        builder.setContentIntent(pi)

        val myNotification = builder.build()

        // display notification
        nManager.notify(1, myNotification)
    }

}