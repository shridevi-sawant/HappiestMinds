package com.happiestminds.receiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        // code to react to event, complete in 10 sec because execution happens on mainthread
        // if more than 10 sec, ANR dialog is displayed by android system

        Log.d("MyReceiver", "Broadcast received with action ${intent.action}")


        when (intent.action) {
            Telephony.Sms.Intents.SMS_RECEIVED_ACTION -> {
                // SMS received
                val msgList = Telephony.Sms.Intents.getMessagesFromIntent(intent)
                if (msgList.isNotEmpty()){
                    val sender = msgList[0].displayOriginatingAddress
                    val smsbody = msgList[0].displayMessageBody
                    Toast.makeText(context, "SMS Received from $sender\n $smsbody",
                        Toast.LENGTH_LONG).show()
                }

            }
            Intent.ACTION_BOOT_COMPLETED -> {
                // received boot completed broadcast
                Toast.makeText(context, "BootCompleted Received...", Toast.LENGTH_LONG).show()
            }
            else -> {
                // download complete
                Toast.makeText(context, "Download completed...", Toast.LENGTH_LONG).show()
            }
        }
    }
}