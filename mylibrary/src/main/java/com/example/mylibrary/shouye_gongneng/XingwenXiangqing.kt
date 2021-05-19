package com.example.city7_1.shouye_gongneng

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.R
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import kotlinx.android.synthetic.main.activity_xingwen_xiangqing.*
import kotlinx.android.synthetic.main.activity_xingwen_yemian.iv_back

class XingwenXiangqing : AppCompatActivity(R.layout.activity_xingwen_xiangqing) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        val position = intent.getIntExtra("position", 0)
        OK.doImageView(MyUity.xingwenList[position].imgUrl,iv_xingwenImage)
        tv_xingwenTitle.text = MyUity.xingwenList[position].title
        tv_xingwenType.text = MyUity.xingwenList[position].pressCategory
        tv_xingwenContent.text = MyUity.xingwenList[position].content
        tv_viewsNumber.text = MyUity.xingwenList[position].viewsNumber.toString()
        val sp = getSharedPreferences("dianzan", Context.MODE_PRIVATE)
        val a = sp.getInt("a", 0)
        iv_dianzan.setOnClickListener {
            val dianzan = tv_dianzan.text.toString().trim()
            val viewsNumber = tv_viewsNumber.text.toString().trim()
            if(dianzan == "点赞"){
                iv_dianzan.setBackgroundResource(R.drawable.dianzan_off)
                tv_viewsNumber.text = (viewsNumber.toInt() + 1).toString()
                tv_dianzan.text = "取消"
            }else{
                iv_dianzan.setBackgroundResource(R.drawable.dianzan_no)
                tv_viewsNumber.text = (viewsNumber.toInt() -  1).toString()
                tv_dianzan.text = "点赞"
            }
        }
    }
}