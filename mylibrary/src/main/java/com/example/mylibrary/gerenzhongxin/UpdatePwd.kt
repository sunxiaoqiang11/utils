package com.example.city7_1.gerenzhongxin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.city7_1.R
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.show
import kotlinx.android.synthetic.main.activity_update_pwd.*
import org.json.JSONObject

class UpdatePwd : AppCompatActivity(R.layout.activity_update_pwd) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        bt_confirm.setOnClickListener {
            val oldPwd = et_oldPwd.text.toString().trim()
            val newPwd = et_newPwd.text.toString().trim()
            if(oldPwd.isEmpty() || newPwd.isEmpty()){
                show("原密码和新密码不能为空")
                return@setOnClickListener
            }
            val sp = getSharedPreferences("login", Context.MODE_PRIVATE)
            val pwd = sp.getString("pwd", "")
            if(pwd != oldPwd){
                show("原密码错误")
                return@setOnClickListener
            }
            val jsonObject = JSONObject()
            jsonObject.put("userId",MyUity.user?.userId)
            jsonObject.put("oldPwd",oldPwd)
            jsonObject.put("password",newPwd)
            OK.doPut("/system/user/resetPwd",jsonObject.toString(),block = {
                runOnUiThread {
                    show("修改成功,请重新登录")
                    finishAffinity()
                    startActivity(Intent(this,LoginActivity::class.java))
                }
            })
        }
    }
}