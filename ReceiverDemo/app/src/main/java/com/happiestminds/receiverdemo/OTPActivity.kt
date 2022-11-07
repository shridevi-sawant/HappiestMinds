package com.happiestminds.receiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.widget.EditText

class OTPActivity : AppCompatActivity() {

    val receiver = OTPReceiver()
    lateinit var otpEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)
        // register receiver
        otpEditText = findViewById(R.id.editTextNumber)

        val intentFilter = IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)
        registerReceiver(receiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    // local receiver
    inner class OTPReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, smsIntent: Intent?) {
            val messages = Telephony.Sms.Intents.getMessagesFromIntent(smsIntent)
            if (messages.isNotEmpty()){
                val otp = messages[0].displayMessageBody
                otpEditText.setText(otp)
            }
        }

    }
}