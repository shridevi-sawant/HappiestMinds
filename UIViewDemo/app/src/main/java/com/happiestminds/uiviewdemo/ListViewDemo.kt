package com.happiestminds.uiviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ListViewDemo : AppCompatActivity() {

    lateinit var listViewColor: ListView
    lateinit var colorTextView: TextView
    lateinit var parentView: ConstraintLayout

    val colorList = mutableListOf("Red", "Blue", "Green", "Orange",
        "Yellow", "White", "Black", "Magenta")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_demo)

        parentView = findViewById(R.id.parentL)
        listViewColor = findViewById(R.id.lv)
        colorTextView = findViewById(R.id.colorT)

        // Create Adapter - data binding, defines listitem layout
        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, colorList)

        listViewColor.adapter = adapter

        listViewColor.setOnItemClickListener { adapterView, view, index, l ->
            val selectedColor = colorList[index]
            colorTextView.text = "Selected Color: $selectedColor"
            var bgColor : Int = Color.BLACK
            when (index){
                0 -> bgColor = Color.RED
                1 -> bgColor = Color.BLUE
                2 -> bgColor = Color.GREEN
                3 -> bgColor = Color.rgb(255, 0, 255)

            }
            parentView.setBackgroundColor(bgColor)
        }
    }
}