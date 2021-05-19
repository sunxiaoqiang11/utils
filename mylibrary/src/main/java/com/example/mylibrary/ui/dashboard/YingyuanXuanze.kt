package com.example.city7_1.ui.dashboard

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.R
import com.example.city7_1.bean.JabYingpgpxz
import com.example.city7_1.goup.Xuanzecuow
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import kotlinx.android.synthetic.main.activity_chang_ci_xuanze.*
import kotlinx.android.synthetic.main.activity_dingzhi_goupiao.*

class YingyuanXuanze : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chang_ci_xuanze)
        val position = intent.getIntExtra("position", 0)
        xuanzechangc_fanh.setOnClickListener { finish() }
        xuanzechangc_name.text = MyUity.yingYuanList[position].cinema_name
        xuanzechangc_dizhi.text = MyUity.yingYuanList[position].specified_address
        xuanzechangc_dengm_pingf.rating = MyUity.movieList[position].score.toFloat()
        OK.imageView(MyUity.movieList[position].poster,xuanzechangc_dengm_tup)
        xuanzechangc_dengm_name.text = MyUity.movieList[position].name
        xuanzechangc_ls_kaistime.text = "开始时间：${MyUity.movieList[position].public_date}"
        xuanzechangc_ls_guangbtime.text = "${MyUity.movieList[position].movie_long}分后结束"
        xuanzechangc_ls_yingpleix.text = "播放类型：${MyUity.movieList[position].type}"
        xuanzechangc_ls_bofangleix.text = "播放类型：${MyUity.movieList[position].language}"
        xuanzechangc_ls_danjia.text = "单价：78元"
        xuanzechangc_ls_goupiao.setOnClickListener {
            startActivity(Intent(this,Xuanzecuow::class.java))
        }
    }
}