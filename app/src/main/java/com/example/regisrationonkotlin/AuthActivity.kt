package com.example.regisrationonkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.regisrationonkotlin.db.DbHelper

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val email: EditText = findViewById(R.id.emailFieldsAuth)
        val pass :EditText = findViewById(R.id.userPasswordFieldsAuth)
        val signIn: Button = findViewById(R.id.signInButton)
        val linkReg:TextView = findViewById(R.id.linkToReg)

        linkReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        signIn.setOnClickListener {
            val userEmail = email.text.toString()
            val userPass = pass.text.toString()

            if (userEmail == "" || userPass == ""){
                Toast.makeText(this, "Fields connot be empty", Toast.LENGTH_SHORT).show()
            }
            else{
                val db = DbHelper(this, null)
                if (db.getUser(userEmail,userPass)){
                    email.text.clear()
                    pass.text.clear()

                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}