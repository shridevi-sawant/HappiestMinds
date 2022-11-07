package com.happiestminds.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rView: RecyclerView
    val listOfStudents = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupData()

        rView = findViewById(R.id.rView)

        // layoutmanager - positioning of items
        rView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            //GridLayoutManager(this,1)




        // adapter - data binding
        rView.adapter = StudentAdapter(listOfStudents){ std, pos ->
            // show popup menu
            val vHolder = rView.findViewHolderForAdapterPosition(pos)
            val view = rView.findContainingItemView(vHolder?.itemView!!)

            val pMenu = PopupMenu(this, view)
            pMenu.menu.add("Delete")
            pMenu.menu.add("Edit")
            pMenu.show()

            pMenu.setOnMenuItemClickListener {
                when(it.title){
                    "Delete" -> {
                        deleteStudent(std, pos)
                        true
                    }
                    "Edit" -> {
                        editStudent(std, pos)
                        true
                    }
                    else -> false

                }
            }


        }
    }

    private fun editStudent(std: Student, pos: Int) {
        val updatedName = std.name.uppercase()
        listOfStudents[pos].name = updatedName
        rView.adapter?.notifyItemChanged(pos)
    }

    private fun setupData() {

        listOfStudents.add(Student(1, "John Smith", 80))
        listOfStudents.add(Student(2, "Merry Rose", 88))
        listOfStudents.add(Student(3, "Mark Smith", 34))
        listOfStudents.add(Student(4, "Robert Laidlaw", 90))
        listOfStudents.add(Student(5, "Terry ", 69))
        listOfStudents.add(Student(6, "Mike Tyson", 59))
        listOfStudents.add(Student(7, "Mike Johnson", 78))
        listOfStudents.add(Student(8, "Steve Jobs", 77))
    }

    private fun deleteStudent(std: Student, position: Int){
        listOfStudents.remove(std)
        Log.d("MainActivity", "Student deleted ${std.name}")
        //rView.adapter?.notifyDataSetChanged()
        rView.adapter?.notifyItemRemoved(position)

    }



}







