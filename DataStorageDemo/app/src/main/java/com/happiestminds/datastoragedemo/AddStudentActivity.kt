package com.happiestminds.datastoragedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class AddStudentActivity : AppCompatActivity() {
    lateinit var rollEditText: EditText
    lateinit var nameEditText: EditText
    lateinit var marksEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        rollEditText = findViewById(R.id.rollE)
        nameEditText = findViewById(R.id.nameE)
        marksEditText = findViewById(R.id.marksE)
    }

    fun buttonClick(view: View) {

        val rollNumber = rollEditText.text.toString()
        val name = nameEditText.text.toString()
        val marks = marksEditText.text.toString()

        when {
            rollNumber.isEmpty() -> rollEditText.error = "Roll number is mandatory"
            name.isEmpty() -> nameEditText.error = "Name is mandatory"
            marks.isEmpty() -> marksEditText.error = "Marks should be entered"
            else -> {
                // add student details to database
                val std = Student(rollNumber.toInt(), name, marks.toInt())
                if (DBWrapper(this).addStudent(std)){
                    Toast.makeText(this, "Student details added",
                        Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(this, "Student details NOT added",
                        Toast.LENGTH_LONG).show()


            }
        }

    }
}