package com.happiestminds.webcommdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var pincodeEditText: EditText
    lateinit var pBar: ProgressBar
    val placeList = mutableListOf<Place>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pincodeEditText = findViewById(R.id.codeE)
        pBar = findViewById(R.id.progressBar)
    }

    fun searchClick(view: View) {
        placeList.clear()
        val code = pincodeEditText.text.toString()
        if (code.length == 6){
            pBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.Default).launch {
                getPlaces(code)

                CoroutineScope(Dispatchers.Main).launch {
                    pBar.visibility = View.INVISIBLE
                    if (placeList.isNotEmpty()){
                        val frag = PlaceFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.placeHolderF, frag)
                            .commit()
                    }else {
                        Toast.makeText(this@MainActivity,
                            "Could not get places for pincode $code",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }

        }else{
            Toast.makeText(this, "Enter proper postal code(6 digits)",
                Toast.LENGTH_LONG).show()
        }
    }

    private fun getPlaces(code: String) {
        // do HTTP communication
        val urlS = "http://api.geonames.org/postalCodeSearchJSON?postalcode=$code&maxRows=10&username=shree"
        val urlObj = URL(urlS)
        val connection = urlObj.openConnection() as HttpURLConnection
        connection.connectTimeout = 15000
        connection.readTimeout = 15000

        when (connection.responseCode){
            200 -> {
                Log.d("MainActivity", "SUCCESS")
                val inpReader = InputStreamReader(connection.inputStream)
                val reader = BufferedReader(inpReader)
                var line =reader.readLine()
                var response = ""
                do {
                    response += line
                    line = reader.readLine()
                }while (line != null)

                Log.d("MainActivity", "Response: $response")

                parseResponse(response)
            }
            else -> Log.d("MainActivity",
                "FAiled to get response ${connection.responseCode}," +
                        " ${connection.responseMessage}")
        }


    }

    private fun parseResponse(response: String) {
        val respObj = JSONObject(response)
        val placesArray = respObj.getJSONArray("postalCodes")
        if (placesArray.length() > 0){
            var placeObj : JSONObject
            var count = 0
            do{
                placeObj = placesArray[count] as JSONObject
                val pName = placeObj.getString("placeName")
                var pCity = ""
                if (placeObj.has("adminName2")){
                    pCity = placeObj.getString("adminName2")
                }
                var pState = ""
                if (placeObj.has("adminName1"))
                    pState = placeObj.getString("adminName1")
                val pCCode = placeObj.getString("countryCode")
                val latt = placeObj.getDouble("lat")
                val longi = placeObj.getDouble("lng")

                val place = Place(pName,pCity,pCCode,pState, latt, longi)
                placeList.add(place)
                count++

            }while (count < placesArray.length())

            Log.d("MainActivity", "List: $placeList")
        }

    }


}