package com.example.city7_1.shouye_gongneng

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import com.example.city7_1.R
import com.example.city7_1.bean.Yingpian
import com.example.city7_1.uite.*
import kotlinx.android.synthetic.main.activity_yingpian_pinglun.*
import kotlinx.android.synthetic.main.activity_yingpian_pinglun.view.*
import kotlinx.android.synthetic.main.comment_list.view.*
import kotlinx.android.synthetic.main.comment_list.view.rb_score
import kotlinx.android.synthetic.main.dialog_comment.*
import kotlinx.android.synthetic.main.dialog_comment.view.*
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class YingpianPinglun : AppCompatActivity(R.layout.activity_yingpian_pinglun) {
    val yingpianList = mutableListOf<Yingpian>()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        OK.imageView(MyUity.movieList[0].poster,iv_movieImage)
        tv_movieName.text = MyUity.movieList[0].name
        tv_movieType.text = "影片类型:${MyUity.movieList[0].type}"
        tv_playTime.text = "播放时间:${MyUity.movieList[0].movie_long}"
        rb_score.rating = MyUity.movieList[0].score.toFloat()
        data()
    }

    private fun data() {
        yingpianList.clear()
        val jsonObject = JSONObject()
        jsonObject.put("movieId",1)
        bt_comment.setOnClickListener {
            dialog()
        }
        OK.Post("/getpinglunmovie",jsonObject.toString(),block = {
            it.request("data",yingpianList)
            runOnUiThread {
                lv_comment.adapter = MyBase<Yingpian>(yingpianList,R.layout.comment_list,block = {a,b,c ->
                    a.apply {
                        OK.imageView(MyUity.movieList[0].poster,this.iv_touXiang)
                        this.tv_nickName.text = b.userId
                        this.rb_score.rating = (b.score / 2).toFloat()
                        this.tv_commentTime.text = b.date
                        this.tv_comment.text = b.content
                    }
                })
            }
        })
    }

    @SuppressLint("SimpleDateFormat")
    private fun dialog() {
        AlertDialog.Builder(this).let {
            val dialog = it.create()
            dialog.setTitle("写评论")
            val inflate = View.inflate(this, R.layout.dialog_comment, null)
            dialog.setView(inflate)
            dialog.show()
            inflate.bt_submit.setOnClickListener {
                val comment = inflate.et_comment.text.toString().trim()
                val pingFen = inflate.rb_pingFen.rating.toString().trim()
                if(TextUtils.isEmpty(comment)){
                    show("请输入你的评论")
                    return@setOnClickListener
                }
                val sdf = SimpleDateFormat("yyyy-MM-dd")
                val jsonObject = JSONObject()
                jsonObject.put("userId","admin")
                jsonObject.put("movieId","1")
                jsonObject.put("score",pingFen)
                jsonObject.put("content",comment)
                jsonObject.put("date",sdf.format(Date()))
                OK.Post("/setpinglunmovie",jsonObject.toString(),block = {
                    runOnUiThread {
                        dialog.dismiss()
                        data()
                    }
                })
            }
        }
    }
}