package com.example.city7_1.goup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.R
import com.example.city7_1.bean.JabYingpgpxz
import com.example.city7_1.uite.OK
import kotlinx.android.synthetic.main.activity_chang_ci_xuanze.*
import kotlinx.android.synthetic.main.activity_dingzhi_goupiao.*

class ChangCiXuanze : Activity() {
    var reming = mutableListOf<JabYingpgpxz>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chang_ci_xuanze)
        reming.add(intent.getSerializableExtra("jihe") as JabYingpgpxz)
        xuanzechangc_fanh.setOnClickListener { finish() }
        xuanzechangc_name.text = reming[0].cinema_name
        xuanzechangc_dizhi.text = reming[0].specified_address
        xuanzechangc_dengm_pingf.rating = reming[0].score.toFloat()
        OK.imageView(reming[0].poster,xuanzechangc_dengm_tup)
        xuanzechangc_dengm_name.text = reming[0].name
        xuanzechangc_ls_kaistime.text = "开始时间：${reming[0].show_date} ${reming[0].show_time}"
        xuanzechangc_ls_guangbtime.text = "${reming[0].movie_long}分后结束"
        xuanzechangc_ls_yingpleix.text = "播放类型：${reming[0].type}"
        xuanzechangc_ls_bofangleix.text = "播放类型：${reming[0].language}"
        xuanzechangc_ls_danjia.text = "单价：${reming[0].price}元"
        xuanzechangc_ls_goupiao.setOnClickListener {
            startActivity(Intent(this,Xuanzecuow::class.java))
        }
    }
}