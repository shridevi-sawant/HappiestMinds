package com.happiestminds.testingdemo

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val testRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testLayout(){
        // get Scenario object
        val scenario = testRule.scenario

        scenario.onActivity {
            val titleT = it.findViewById<TextView>(R.id.textView)
            assertNotNull("TextView should be present",titleT)

            val nameE = it.findViewById<EditText>(R.id.nameE)
            assertNotNull("EditText to enter name is required", nameE)

            val btn = it.findViewById<Button>(R.id.button)
            assertNotNull("Button is required", btn)
        }
    }

    @Test
    fun testViews(){

        val scenario = testRule.scenario

        scenario.onActivity {
            val titleT = it.findViewById<TextView>(R.id.textView)
            val actualText = titleT.text
            assertEquals("Hello World!", actualText)

            val nameE = it.findViewById<EditText>(R.id.nameE)
            assertEquals("", nameE.text.toString())

            val btn = it.findViewById<Button>(R.id.button)
            assertEquals("NEXT", btn.text.toString().uppercase())
        }
    }

    @Test
    fun testBtnClick(){

        testRule.scenario.onActivity {
            val nameE = it.findViewById<EditText>(R.id.nameE)
            nameE.setText("demo")

            val btn = it.findViewById<Button>(R.id.button)
            btn.performClick()

            val titleT = it.findViewById<TextView>(R.id.textView)
            assertEquals("Hello demo", titleT.text)

            assertEquals("", nameE.text.toString())

        }
    }
}