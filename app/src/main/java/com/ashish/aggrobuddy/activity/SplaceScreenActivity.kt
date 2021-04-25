package com.ashish.aggrobuddy.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.ashish.aggrobuddy.R

class SplaceScreenActivity : AppCompatActivity() {

    lateinit var handler:Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)

        handler= Handler()
        handler.postDelayed({
            val intent= Intent(this@SplaceScreenActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}