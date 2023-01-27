package com.example.pomodoro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager

class MainActivity4 : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        supportActionBar?.hide()

        handler=Handler()
        handler.postDelayed({
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}
