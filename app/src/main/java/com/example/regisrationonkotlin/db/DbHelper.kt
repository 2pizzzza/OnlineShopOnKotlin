package com.example.regisrationonkotlin.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.regisrationonkotlin.entity.User

class DbHelper(val context :Context, val factory: SQLiteDatabase.CursorFactory? ) :
    SQLiteOpenHelper(context, "app", factory, 1 ) {
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, email TEXT, username TEXT, password TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User){
        val values = ContentValues()
        values.put("email",  user.email )
        values.put("username",  user.name )
        values.put("password",  user.password )

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()
    }
}