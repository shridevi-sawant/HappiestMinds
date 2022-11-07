package com.happiestminds.uiviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.google.android.material.snackbar.Snackbar

class CheckBoxDemo : AppCompatActivity() {
    lateinit var blrCheckBox: CheckBox
    lateinit var bomCheckBox: CheckBox
    lateinit var hydCheckBox: CheckBox
    lateinit var chnCheckBox: CheckBox
    lateinit var dlhCheckBox: CheckBox

    val selectedCities = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box_demo)

        blrCheckBox = findViewById(R.id.blrC)
        bomCheckBox = findViewById(R.id.bomC)
        hydCheckBox = findViewById(R.id.hydC)
        chnCheckBox = findViewById(R.id.chnC)
        dlhCheckBox = findViewById(R.id.dlhC)
    }

    fun doneClick(view: View) {
        selectedCities.clear()

        if (blrCheckBox.isChecked)
            selectedCities.add("Bangalore")
        if (bomCheckBox.isChecked)
            selectedCities.add("Mumbai")
        if (hydCheckBox.isChecked)
            selectedCities.add("Hyderabad")
        if (chnCheckBox.isChecked)
            selectedCities.add("Chennai")
        if (dlhCheckBox.isChecked)
            selectedCities.add("Delhi")

        Snackbar.make(chnCheckBox,
            "Locations: $selectedCities", 5000).show()
    }
}