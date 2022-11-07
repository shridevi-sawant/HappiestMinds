package com.happiestminds.datastoragedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class StudentListActivity : AppCompatActivity() {

    val studentList = mutableListOf<Student>()
    lateinit var adapter: ArrayAdapter<Student>
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        listView = findViewById(R.id.studentL)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            studentList)

        listView.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        setupData()
    }

    private fun setupData() {
        val cursor = DBWrapper(this).getAllStudents()
        if (cursor.count > 0) {
            val idx_roll = cursor.getColumnIndexOrThrow(DBHelper.CLM_ROLL_NUM)
            val idx_name = cursor.getColumnIndexOrThrow(DBHelper.CLM_NAME)
            val idx_marks = cursor.getColumnIndexOrThrow(DBHelper.CLM_MARKS)
            cursor.moveToFirst()
            studentList.clear()

            do {
                val roll = cursor.getInt(idx_roll)
                val marks = cursor.getInt(idx_marks)
                val name = cursor.getString(idx_name)

                val std = Student(roll, name, marks)
                studentList.add(std)
            } while (cursor.moveToNext())

            studentList.sortBy {
                it.marks
            }
            studentList.reverse()

            adapter.notifyDataSetChanged()

            Log.d("StudentListActivity", "List: $studentList")
            Toast.makeText(
                this, "Found: ${studentList.count()}",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun addClick(view: View) {
        val intent = Intent(this, AddStudentActivity::class.java)
        startActivity(intent)
    }
}