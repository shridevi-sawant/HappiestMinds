package com.happiestminds.locationdemo

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity(), LocationListener {
    lateinit var locationTextView: TextView
    lateinit var locManager: LocationManager
    var firstLocation : Location? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationTextView = findViewById(R.id.locT)

        setup()
    }

    private fun setup() {
        // get LocationManager
        locManager = getSystemService(LOCATION_SERVICE) as LocationManager

        // check for location permissions
        if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED)
        {
            Log.d("MainActivity", "Permission not granted")
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }
        else {
            Log.d("MainActivity", "Permission is granted already")
            startTracking()
        }

    }

    @SuppressLint("MissingPermission")
    private fun startTracking() {
        Log.d("MainActivity", "Starting to track user")
        var selectedProvider = LocationManager.NETWORK_PROVIDER

        val enabledProviders = locManager.getProviders(true)
        if (enabledProviders.contains(LocationManager.GPS_PROVIDER)){
            selectedProvider = LocationManager.GPS_PROVIDER
        }else if (enabledProviders.contains(LocationManager.NETWORK_PROVIDER)){
            selectedProvider = LocationManager.NETWORK_PROVIDER
        }else {
            selectedProvider = enabledProviders[0]
        }
        Log.d("MainActivity", "Selected Provider : $selectedProvider")

        locManager.requestLocationUpdates(selectedProvider, 1_000, 10.0f, this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.isNotEmpty()){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.d("MainActivity", "Permission granted by user")
                startTracking()
            }
            else {
                Log.d("MainActivity", "Permission NOT granted by user")
                locationTextView.text = """
                    Permission required to track your location
                    Go to AppInfo->Permissions and allow the permission
                """.trimIndent()
            }
        }
    }

    override fun onLocationChanged(location: Location) {
        if (firstLocation == null)
            firstLocation = location

        val distance = firstLocation?.distanceTo(location)
        val postalAddr = getAddress(location)

        locationTextView.text = """
            Current Location: ${location.latitude}, ${location.longitude}
            
            Distance Travelled: ${distance!!/1000} kms
            
            Address: $postalAddr
        """.trimIndent()


    }

    private fun getAddress(location: Location): String? {
        // reverse geocoding
        val gCoder = Geocoder(this)
        try {
            val addrList = gCoder.getFromLocation(location.latitude,
                location.longitude, 1)

            if (addrList.isNotEmpty()){
                val addr = addrList[0]
                val streetAddr = """
                    ${addr.subLocality}, ${addr.locality},
                    ${addr.adminArea}, ${addr.postalCode},
                    ${addr.countryName}
                """.trimIndent()

                return streetAddr
            } else {
                return null
            }
        }catch (err: Exception){
            Log.d("MainActivity", "Could not get address ${err.localizedMessage}")
            return null
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        locManager.removeUpdates(this)
    }
}