package com.happiestminds.datastoragedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.io.File
import java.io.FileNotFoundException

class AddressActivity : AppCompatActivity() {
    lateinit var addressEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        addressEditText = findViewById(R.id.addrE)


    }

    override fun onResume() {
        super.onResume()
        // read address from file
        val addr = readFromFile("address.txt")
        addressEditText.setText(addr)
    }

    private fun readFromFile(fileName: String): String {
        return try {
            val fis = openFileInput(fileName)
            val data = ByteArray(1024)
            fis.read(data)
            data.decodeToString()
        }catch (err: FileNotFoundException){
            ""
        }

    }

    fun addClick(view: View) {
        // grab address and save it in file

        val address = addressEditText.text.toString()
        if (address.isNotEmpty()){
            //save it
            writeToFile("address.txt", address)
        }
        else
            addressEditText.error = "Address should not be empty"
    }

    private fun writeToFile(filename: String, data: String) {
//        val fos = openFileOutput(filename, MODE_PRIVATE)
//        fos.write(data.toByteArray())
//        fos.close()
        Toast.makeText(this, "Data saved to file $filename",
            Toast.LENGTH_LONG).show()

        val newFile = File(getExternalFilesDir(null), filename)
        val fos = newFile.outputStream()
        fos.write(data.toByteArray())
        fos.close()
    }
}