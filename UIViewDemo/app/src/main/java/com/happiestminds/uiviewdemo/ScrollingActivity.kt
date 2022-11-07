package com.happiestminds.uiviewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer
import kotlin.concurrent.schedule

class ScrollingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)

        Timer().schedule(5000){

            runOnUiThread {
                val mainIntent = Intent(this@ScrollingActivity,
                    MainActivity().javaClass)
                startActivity(mainIntent)
            }

        }
    }
}