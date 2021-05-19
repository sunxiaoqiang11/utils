package com.example.city7_1.shouye_gongneng

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.R
import com.example.city7_1.bean.Movie
import com.example.city7_1.goup.GoupiaoJieshao
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import kotlinx.android.synthetic.main.activity_tuijian_yingyuan.*
import kotlinx.android.synthetic.main.activity_tuijian_yingyuan.lv_movie
import kotlinx.android.synthetic.main.movie_list.view.*

class TuijianYingyuan : AppCompatActivity(R.layout.activity_tuijian_yingyuan) {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        lv_movie?.let {
            it.adapter = MyBase<Movie>(MyUity.movieList,R.layout.movie_list,block = { a, b, c ->
                a.apply {
                    OK.imageView(b.poster,this.iv_movieImage)
                    this.tv_movieName.text = b.name
                    this.tv_movieType.text = "类型:${b.type}"
                    this.tv_playTime.text = "播放时间:${b.movie_long}"
                    this.rb_score.rating = b.score.toFloat()
                    this.bt_goPiao.setOnClickListener {
                        val intent = Intent(this@TuijianYingyuan, GoupiaoJieshao::class.java)
                        intent.putExtra("reying",b)
                        startActivity(intent)
                    }
                }
            })
        }
    }
}