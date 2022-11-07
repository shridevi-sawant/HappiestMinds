package com.happiestminds.androidintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun buttonClick(view: View) {
        when (view.id){
            R.id.callB -> {
                // open dialer app to make call
                val callIntent = Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:9845267240"))

                startActivity(callIntent)
            }
            R.id.visitB -> {
                // open browser to open website
                val browserIntent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.happiestminds.com"))
                startActivity(browserIntent)
            }
            R.id.emailB -> {
                // open email app to send email
                val emailIntent = Intent(Intent.ACTION_SENDTO,
                    Uri.parse("mailto:abc@gmail.com"))

                emailIntent.putExtra(Intent.EXTRA_CC,
                    arrayOf("contact@happiestminds.com", "test@xyz.com"))

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Service Request")
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hi, Raising request about account updation")

                startActivity(emailIntent)
            }
            R.id.smsB -> {
                val smsIntent = Intent(Intent.ACTION_SENDTO,
                    Uri.parse("smsto:123456789"))
                smsIntent.putExtra("sms_body", "This is test sms..")

                startActivity(smsIntent)
            }
            R.id.contactB -> {
                val pickIntent = Intent(Intent.ACTION_PICK,
                    ContactsContract.Contacts.CONTENT_URI)
                startActivity(pickIntent)

            }
            R.id.locateB -> {
                val mapIntent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:12.34252,77.82534")
                )

                if (mapIntent.resolveActivity(packageManager) != null) {
                    // at least one app available
                    startActivity(mapIntent)
                }
            }
            R.id.picB -> {

                val picIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(picIntent)


            }
        }

    }


}

