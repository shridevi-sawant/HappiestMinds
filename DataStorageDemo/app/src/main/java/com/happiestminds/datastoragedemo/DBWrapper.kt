package com.happiestminds.datastoragedemo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract




class DBWrapper(ctx: Context) {

    val helper = DBHelper(ctx) // tables are ready
    val db = helper.writableDatabase

    fun addStudent(std: Student): Boolean{
        //insert
        val values = ContentValues()
        values.put(DBHelper.CLM_ROLL_NUM, std.roll)
        values.put(DBHelper.CLM_NAME, std.name)
        values.put(DBHelper.CLM_MARKS, std.marks)

        val rowid = db.insert(DBHelper.TABLE_NAME, null, values)
        if (rowid.toInt() == -1){
            return false
        }
        return true
    }

    fun getAllStudents() : Cursor {
        // query
        val clms = arrayOf(DBHelper.CLM_ROLL_NUM, DBHelper.CLM_MARKS, DBHelper.CLM_NAME)

        return db.query(DBHelper.TABLE_NAME, clms,
            null, null, null, null, null )


    }

    fun getAllStudentsOrderByMarks() : Cursor {
        // query
        val clms = arrayOf(DBHelper.CLM_ROLL_NUM, DBHelper.CLM_MARKS, DBHelper.CLM_NAME)

        return db.query(DBHelper.TABLE_NAME, clms,
            null, null, null, null, DBHelper.CLM_MARKS )


    }

    fun deleteStudent(std: Student){
        // delete
        db.delete(DBHelper.TABLE_NAME, "${DBHelper.CLM_ROLL_NUM} = ?",
            arrayOf(std.roll.toString()))
    }
}

data class Student(val roll: Int, val name: String, val marks: Int){
    override fun toString(): String {
        return """
            Roll No: $roll
            Name: $name
            Marks: $marks
        """.trimIndent()
    }
}