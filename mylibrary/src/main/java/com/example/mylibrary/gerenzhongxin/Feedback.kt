package com.example.city7_1.gerenzhongxin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.city7_1.R
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.show
import kotlinx.android.synthetic.main.activity_feedback.*
import org.json.JSONObject

class Feedback : AppCompatActivity(R.layout.activity_feedback) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        et_idea.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv_zi.text = "${start+count}/150字"
            }
        })
        bt_submit.setOnClickListener {
            val idea = et_idea.text.toString().trim()
            if(idea.isEmpty()){
                show("请输入你的看法")
                return@setOnClickListener
            }
            val jsonObject = JSONObject()
            jsonObject.put("content",idea)
            jsonObject.put("userId",MyUity.user?.userId)
            OK.doPost("/userinfo/feedback",jsonObject.toString(),block = {
                runOnUiThread {
                    show("反馈成功")
                    et_idea.setText("")
                }
            })
        }
    }
}