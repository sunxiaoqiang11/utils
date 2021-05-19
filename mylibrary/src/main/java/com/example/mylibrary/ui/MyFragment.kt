package com.example.city7_1.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.View
import com.example.city7_1.R
import com.example.city7_1.gerenzhongxin.*
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.show
import kotlinx.android.synthetic.main.fragment_my.*


class MyFragment : Fragment(R.layout.fragment_my) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (TextUtils.isEmpty(MyUity.toKey)){
            startActivity(Intent(context,LoginActivity::class.java))
            activity?.finish()
            return
        }
        MyUity.user?.let {
            OK.doImageView(it.avatar,iv_userImage)
            tv_userName.text = it.userName
        }
        tv_personInfo.setOnClickListener { startActivity(Intent(context,PersonInfo::class.java)) }
        tv_updatePwd.setOnClickListener { startActivity(Intent(context,UpdatePwd::class.java)) }
        tv_orderList.setOnClickListener { startActivity(Intent(context,OrderList::class.java)) }
        tv_feedback.setOnClickListener {  startActivity(Intent(context,Feedback::class.java))}
        bt_quitLogin.setOnClickListener { startActivityForResult(Intent(context,LoginActivity::class.java),999) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 999){
            show("请登录")
            startActivity(Intent(context,LoginActivity::class.java))
            activity?.finish()
        }
    }
}