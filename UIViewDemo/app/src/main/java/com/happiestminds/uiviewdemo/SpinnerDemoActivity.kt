package com.happiestminds.uiviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class SpinnerDemoActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var selectionT: TextView
    lateinit var colorSpinner: Spinner

    val colorList = mutableListOf("Red", "Blue", "Green", "Black")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner_demo)

        selectionT = findViewById(R.id.colorSpinT)
        colorSpinner = findViewById(R.id.spinner)

        // AdapterViews - Listview, Spinner, RecyclerView

        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_spinner_dropdown_item, colorList)

        colorSpinner.adapter = adapter

        colorSpinner.onItemSelectedListener = this
    }

    override fun onItemSelected(adpterV: AdapterView<*>?, v: View?, index: Int, p3: Long) {

       val selectedColor = colorList[index]
        selectionT.text = "Selected Color: $selectedColor"
        colorList.remove(selectedColor)

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}