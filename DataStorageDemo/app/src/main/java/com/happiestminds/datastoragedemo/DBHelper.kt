package com.happiestminds.datastoragedemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "students.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        // table creation to be done (executed when db not present)
        db?.execSQL(TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // executed when version mismatch
        // drop table, create new table, modify schema of existing tables
    }

    companion object {
        const val TABLE_NAME = "StudentData"
        const val CLM_ROLL_NUM = "roll_no"
        const val CLM_NAME = "name"
        const val CLM_MARKS = "marks"
        private const val TABLE_QUERY = "create table $TABLE_NAME ( $CLM_ROLL_NUM number primary key, " +
                "$CLM_NAME text, $CLM_MARKS number)"
    }
}