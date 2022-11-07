package com.happiestminds.uiviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import com.google.android.material.snackbar.Snackbar

class RadioButtonDemo : AppCompatActivity() {

    lateinit var paymentRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button_demo)

        paymentRadioGroup = findViewById(R.id.paymentG)
        paymentRadioGroup.setOnCheckedChangeListener { rgroup, selectedId ->
            var selectedType = ""
            when (selectedId) {
                R.id.creditR -> {
                    selectedType = "Credit Card"
                }
                R.id.debitR -> selectedType = "Debit Card"
                R.id.gpayR -> selectedType = "Google Pay"
                R.id.paytmR -> selectedType = "PayTm"
            }

            Snackbar.make(this, paymentRadioGroup,
                "Payment via $selectedType", Snackbar.LENGTH_LONG).show()
        }
    }
}