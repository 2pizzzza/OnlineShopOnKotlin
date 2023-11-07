package com.example.regisrationonkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.regisrationonkotlin.db.DbHelper
import com.example.regisrationonkotlin.entity.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userEmail:EditText = findViewById(R.id.emailFields)
        val username:EditText = findViewById(R.id.nameFields)
        val userPassword:EditText = findViewById(R.id.userPasswordFields)
        val registerButton:Button = findViewById(R.id.button)
        val linkToLogin: TextView = findViewById(R.id.linkToAuth)

        registerButton.setOnClickListener{
            val email = userEmail.text.toString()
            val name = username.text.toString()
            val pass = userPassword.text.toString()

            if (email == "" || name == "" || pass == "")
                Toast.makeText(this, "Fields connot be empty", Toast.LENGTH_LONG).show()
            else {
                val user = User(email, name, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Successful create user $name", Toast.LENGTH_LONG).show()

                userEmail.text.clear()
                username.text.clear()
                userPassword.text.clear()

                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)
            }
        }

        linkToLogin.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

    }
}