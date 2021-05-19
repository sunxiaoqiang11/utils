package com.example.city7_1.uite

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.MainActivity
import com.example.city7_1.R

class Guanggaoyemian : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guanggaoyemian)
        Thread(Runnable {
            Thread.sleep(3000)
            MyUity.Kaijugga = false
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }).start()
    }
}