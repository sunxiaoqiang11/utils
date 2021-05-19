package com.example.city7_1.uite

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.example.city7_1.bean.*

class MyUity : Application() {
    companion object{
        lateinit var context: Context
        var Urls = "http://192.168.100.240:10002"
        var Urls_1 = "http://192.168.100.240:8880"
        var toKey = ""
        var Kaijugga = true
        var qzhuylunbt = mutableListOf<String>()
        var qWendPaomd = ""
        var yingYuanList = mutableListOf<YingYuan>()
        var movieList = mutableListOf<Movie>()
        var xingwenList = mutableListOf<Xingwen>()
        var user:User? = null
        var qJijiangshying = mutableListOf<Jabjijshangy>()
        var orderList = mutableListOf<Order>()
    }
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}