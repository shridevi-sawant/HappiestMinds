package com.happiestminds.uidialogdemo

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {
    lateinit var timeTextView: TextView
    lateinit var dateTextView: TextView

    lateinit var timeButton: Button
    lateinit var dateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeTextView = findViewById(R.id.timeT)
        dateTextView = findViewById(R.id.dateT)

        timeTextView.text = "No time selected"
        dateTextView.text = "No date selected"

        timeButton = findViewById(R.id.timeB)
        dateButton = findViewById(R.id.dateB)
    }

    fun closeClick(view: View) {
        // get confirmation from user - use dialog
        // show dialog
        val dlg = MyDialog()
        dlg.isCancelable = false

        val dataBundle = Bundle()

        dataBundle.putString("msg", "Do you want to exit?")

        dlg.arguments = dataBundle
        dlg.show(supportFragmentManager, null)
    }

    override fun onBackPressed() {
        val dlg = MyDialog()
        dlg.isCancelable = false

        val dataBundle = Bundle()

        dataBundle.putString("msg", "Confirm exit from App")
        dlg.arguments = dataBundle
        dlg.show(supportFragmentManager, null)

    }

    fun selectDate(view: View) {
        // show datepickerdialog
        val dlg = DatePickerDialog(this)
        dlg.setOnDateSetListener { dPicker, year, month, day ->
            dateTextView.text = "$day-${month+1}-$year"
            dateButton.isEnabled = false
        }
        dlg.show()
    }
    fun selectTime(view: View) {
        // timepicker dialog
        val dlg = TimePickerDialog(this, this,
            10, 0, true)

        dlg.show()
    }

    override fun onTimeSet(tPicker: TimePicker?, hh: Int, mm: Int) {
        timeTextView.text = "$hh : $mm"

        timeButton.isEnabled = false
        //timeButton.isVisible = false
    }

    fun downloadClick(view: View) {
        //TODO - Start task

        // show progress dialog
//        val dlg = ProgressDialog.show(this, "Downloading", "Please wait")
//
//        Timer().schedule(10000) {
//            dlg.cancel()
//        }

        val sBAr = Snackbar.make(this, timeButton ,
            "Downloading...", Snackbar.LENGTH_INDEFINITE)
        sBAr.setAction("Cancel") {
            sBAr.dismiss()
        }

        sBAr.show()
    }
}