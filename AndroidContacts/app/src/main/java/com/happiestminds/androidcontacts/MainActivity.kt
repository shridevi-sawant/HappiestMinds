package com.happiestminds.androidcontacts

import android.content.Intent
import android.content.pm.PackageManager
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import android.provider.ContactsContract.CommonDataKinds.*
import android.provider.Settings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    lateinit var titleTextView: TextView
    lateinit var callButton: Button
    lateinit var pickContactButton: Button

    var contactName : String = ""
    var numbers = mutableListOf<String>()

    // Use it before activity is created..
    private val contactResult = registerForActivityResult(ActivityResultContracts.
                        StartActivityForResult()){
        if (it.resultCode == RESULT_OK) {
            // grab data
            val selectedContactUri = it.data?.dataString
            titleTextView.text = "Selected contact: $selectedContactUri"

            retrieveContactDetails(it.data?.data!!)

        }
        else if (it.resultCode == RESULT_CANCELED){
            titleTextView.text = "No Contact selected, Select one"
        }
    }

    private fun retrieveContactDetails(selectionUri: Uri) {
        // Name, phone Number

        // 1. from uri - get rowid(contact id)
        val contactID = selectionUri.lastPathSegment!!
        Log.d("MainActivity", "Contact id: $contactID")

        // 2. for that contactid - query PHONE table of contact db

        val cursor = contentResolver.query(Phone.CONTENT_URI,null,
            "${Phone.CONTACT_ID} = ?",
            arrayOf(contactID), null)

        Log.d("MainActivity", "row count: ${cursor?.count}")

        // 3. get phone number from query result

        val idx_name = cursor?.getColumnIndexOrThrow(Phone.DISPLAY_NAME)
        val idx_number = cursor?.getColumnIndexOrThrow(Phone.NUMBER)
        numbers.clear()
        if (cursor?.moveToFirst() == true){

            do{
                contactName = cursor.getString(idx_name!!)
                val number = cursor.getString(idx_number!!)
                numbers.add(number)

            }while (cursor.moveToNext())

            Log.d("MainActivity", "phone numbers of $contactName :$numbers")
            if (numbers.isNotEmpty()) {
                callButton.isEnabled = true
                callButton.text = "CALL $contactName"
            }

        }else {
            Toast.makeText(this, "Selected Contact does not have Phone number",
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.textView)
        callButton = findViewById(R.id.callB)
        pickContactButton = findViewById(R.id.button)

        // request permission from user if not granted

        if (checkSelfPermission(android.Manifest.permission.READ_CONTACTS)
            == PackageManager.PERMISSION_DENIED) {
            Log.d("MainActivity","Permission not granted, request user")

            pickContactButton.isEnabled = false
            requestPermissions(arrayOf(android.Manifest.permission.READ_CONTACTS),
                1)

        }
        else {
            Log.d("MainActivity", "Permission is granted already")
            pickContactButton.isEnabled = true
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1){
            if (permissions.isNotEmpty()){
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Log.d("MainActivity", "User accepted the permission")
                    pickContactButton.isEnabled = true
                } else {
                    Log.d("MainActivity", "User denied the permission")
                    pickContactButton.isEnabled = false
                }
            }
        }
    }


    fun buttonClick(view: View) {

        titleTextView.text = "Selecting Contact"
        
        val i = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        //startActivityForResult(i, 1) // option 1
        contactResult.launch(i) // suggested Option - registerForActivityResult


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1) {

            if (resultCode == RESULT_OK) {
                // grab data from intent
                val selectedContactUri = data?.dataString
                titleTextView.text = "Selection: $selectedContactUri"
            }else if (resultCode == RESULT_CANCELED){
                titleTextView.text = "Select Contact"
                Toast.makeText(this, "No Contact Selected",
                    Toast.LENGTH_LONG).show()
            }
        }
    }

    fun callClick(view: View) {
        val callIntent = Intent(Intent.ACTION_DIAL,
            Uri.parse("tel:${numbers[0]}"))
        startActivity(callIntent)

    }

    fun playClick(view: View) {

        // get ringtone set by user
        val ringUri = Settings.System.DEFAULT_RINGTONE_URI

        val player = MediaPlayer()
        player.setDataSource(this, ringUri)
        player.prepare()
        player.start()
        Log.d("MainActivity", "Playing ringtone ${player.isPlaying}")
        Timer().schedule(2000) {
            player.stop()
        }

    }
}