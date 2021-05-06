package com.ashish.aggrobuddy.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ashish.aggrobuddy.R
import com.ashish.aggrobuddy.SignupActivity

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogIn: Button
    lateinit var txtForgetPassword: TextView
    lateinit var txtRegister: TextView

    val validMobileNumber = arrayOf(
        "6206416452",
        "6287099155"

    )
    val validPassword = arrayOf(
        "Monal@123",
        "Shalu@123"
    )

    lateinit var sharedPreferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences("Aggrobuddy preferences",Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if (isLoggedIn)
        {
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        setContentView(R.layout.activity_login)
        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etqueryPassword)
        btnLogIn = findViewById(R.id.buttonPanellogin)

        txtForgetPassword = findViewById(R.id.textForgotPassword)
        txtRegister = findViewById(R.id.textRegister)

        txtRegister.setOnClickListener {
            val intentSignUp=Intent(this@LoginActivity, SignupActivity::class.java)
            startActivity(intentSignUp)
        }

        txtForgetPassword.setOnClickListener {
            val intentforget=Intent(this@LoginActivity,ForgetActivity::class.java)
            startActivity(intentforget)
        }



        btnLogIn.setOnClickListener {


            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            var nameOfPersonLogin="person"

            val a = 1
            val intent = Intent(this@LoginActivity, MainActivity::class.java)


            if (a != 0) {
                if ((mobileNumber == validMobileNumber[0]) && (password == validPassword[0])) {
                    nameOfPersonLogin=" Welcome Ashish Ranjan"
                    savepreferences(nameOfPersonLogin)

                    startActivity(intent)
                } else if ((mobileNumber == validMobileNumber[1]) && (password == validPassword[1])) {
                    nameOfPersonLogin = " Welcome Shalu Ambasta"
                    savepreferences(nameOfPersonLogin)

                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@LoginActivity, "Invalid Credential",
                        Toast.LENGTH_LONG
                    ).show()
                }


            }
        }
    }

     fun savepreferences(title: String) {
         sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()

         sharedPreferences.edit().putString("nameOfPersonLogin",title).apply()
    }

    override fun  onPause()
    {
        super.onPause()
        finish()

    }

    fun method(view: View) {}
}


