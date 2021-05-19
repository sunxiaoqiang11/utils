package com.example.city7_1.shouye_gongneng

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.R
import com.example.city7_1.bean.Xingwen
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.request
import kotlinx.android.synthetic.main.activity_xingwen_yemian.*
import kotlinx.android.synthetic.main.xingwen_list.view.*

class XingwenYemian : AppCompatActivity(R.layout.activity_xingwen_yemian) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        if(MyUity.xingwenList.size == 0) xinwen() else xinwenAdapter()
    }

    private fun xinwen() {
        OK.doGet("/press/press/list?pageNum=1&pageSize=10&pressCategory=36",block = {
            it.request("rows",MyUity.xingwenList)
            runOnUiThread { xinwenAdapter() }
        })
    }

    @SuppressLint("SetTextI18n")
    private fun xinwenAdapter() {
        lv_xingwen?.let {
            it.adapter = MyBase<Xingwen>(MyUity.xingwenList,R.layout.xingwen_list,block = {a,b,c ->
                a.apply {
                    OK.doImageView(b.imgUrl,this.iv_xingwenImage)
                    this.tv_xingwenTitle.text = b.title
                    this.tv_xingwenContent.text = b.content
                    this.tv_viewsNumber.text = "点赞数:${b.viewsNumber}"
                    this.tv_createTime.text = "发布日期:${b.createTime}"
                }
            })
            it.setOnItemClickListener { parent, view, position, id ->
                Intent(applicationContext,XingwenXiangqing::class.java).apply {
                    putExtra("position",position)
                    startActivity(this)
                }
            }
        }
    }
}