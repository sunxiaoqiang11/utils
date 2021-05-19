package com.example.city7_1.gerenzhongxin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.R
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.show
import kotlinx.android.synthetic.main.activity_person_info.*
import okhttp3.MultipartBody

class PersonInfo : AppCompatActivity(R.layout.activity_person_info) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }

        MyUity.user?.let {
            OK.doImageView(it.avatar,iv_userImage)
            et_nickName.setText(it.nickName)
            if(it.sex == "0"){
                rb_woman.isChecked = true
            }else{
                rb_man.isChecked = true
            }
            et_phone.setText(it.phonenumber)
            val idCard = it.idCard
            if(idCard.length == 18){
                val sb = StringBuffer(idCard)
                val replace = sb.replace(2, 14, "************")
                et_idCard.setText(replace)
            }else{
                et_idCard.setText(idCard)
                show("身份证有误,尽快修改")
            }
        }
        bt_update.setOnClickListener {
            val nickName = et_nickName.text.toString().trim()
            val phone = et_phone.text.toString().trim()
            val idCard = et_idCard.text.toString().trim()

            if(nickName.isEmpty() || phone.isEmpty() || idCard.isEmpty()){
                show("请输入完整信息")
                return@setOnClickListener
            }
            if (idCard.length != 18){
                show("输入正确的身份证(18位)")
                return@setOnClickListener
            }
            val builder = MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("userId", MyUity.user?.userId.toString())
                .addFormDataPart("idCard", idCard)
                .addFormDataPart("nickName", nickName)
                .addFormDataPart("phonenumber", phone)
                .addFormDataPart("sex", if (rb_woman.isChecked) "0" else "1")
            OK.doMublit("/system/user/updata",builder.build(),block = {
                runOnUiThread {
                    show("修改成功,请重新登录")
                    finishAffinity()
                    startActivity(Intent(this,LoginActivity::class.java))
                }
            })
        }
    }
}