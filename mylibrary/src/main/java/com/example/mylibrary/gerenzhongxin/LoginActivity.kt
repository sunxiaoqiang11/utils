package com.example.city7_1.gerenzhongxin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.city7_1.MainActivity
import com.example.city7_1.R
import com.example.city7_1.bean.User
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.show
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sp = getSharedPreferences("login", Context.MODE_PRIVATE)
        val username = sp.getString("username", "admin")
        val password = sp.getString("pwd", "admin123")
        et_userName.setText(username)
        et_pwd.setText(password)
        bt_login.setOnClickListener {
            val userName = et_userName.text.toString().trim()
            val pwd = et_pwd.text.toString().trim()
            if(userName.isEmpty() || pwd.isEmpty()){
                show("账号或密码不能为空")
                return@setOnClickListener
            }
            val jsonObject = JSONObject()
            jsonObject.put("username",userName)
            jsonObject.put("password",pwd)
            OK.doPost("/login",jsonObject.toString(),block = {
                if(it.optInt("code") != 200){
                    Handler(Looper.getMainLooper()).post {
                        show(it.optString("msg"))
                    }
                }else{
                    MyUity.toKey = it.getString("token")
                    val edit = sp.edit()
                    edit.putString("username",userName)
                    edit.putString("pwd",pwd)
                    edit.commit()
                    OK.doGetKey("/getInfo",block = {
                        val user = it.getJSONObject("user")
                        MyUity.user = Gson().fromJson(user.toString(), User::class.java)
                        finishAffinity()
                        startActivity(Intent(applicationContext,MainActivity::class.java))
                    })
                }
            })
        }
    }
}