package com.happiestminds.uiviewdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        when(view.id){
            R.id.spinnerB -> {
                val spinnerIntent = Intent(this, SpinnerDemoActivity().javaClass)
                startActivity(spinnerIntent)
            }
            R.id.listviewB -> {
               // showToast("Clicked Button: Listview Demo")
                val listIntent = Intent(this, ListViewDemo().javaClass)
                startActivity(listIntent)

            }
            R.id.radioB -> {
               // showToast("Clicked Button: RadioButton Demo")
                val radioIntent = Intent(this, RadioButtonDemo().javaClass)
                startActivity(radioIntent)

            }
            R.id.checkboxB -> {
                // launch activity
                val checkIntent = Intent(this, CheckBoxDemo().javaClass)
                startActivity(checkIntent)


            }
        }
    }
}

fun AppCompatActivity.showToast(msg: String){
    Toast.makeText(this, msg,
        Toast.LENGTH_LONG).show()
}