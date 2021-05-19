package com.example.city7_1.goup

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.city7_1.R
import com.example.city7_1.bean.JabPlunyp
import com.example.city7_1.bean.Movie
import com.example.city7_1.bean.YingYuan
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.show
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_goupiao_jieshao.*
import kotlinx.android.synthetic.main.pinglshuj_list.view.*
import kotlinx.android.synthetic.main.xiepingl_tanc.*
import kotlinx.android.synthetic.main.xiepingl_tanc.view.*
import kotlinx.android.synthetic.main.xiepingl_tanc.view.pingl_xie_neir
import org.json.JSONObject

class GoupiaoJieshao : Activity() {
    val reming = mutableListOf<Movie>()
    var mPinglun = mutableListOf<JabPlunyp>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goupiao_jieshao)
        reming.add(intent.getSerializableExtra("reying") as Movie)
        if (reming.size != 0){
            Addshuj()
        }
    }
    private fun Addshuj() {
        ticket_fanh.setOnClickListener { finish() }
        OK.imageView(reming[0].poster, iv_movieImage)
        tv_movieName.text = reming[0].name
        tv_movieType.text = "类型：${reming[0].type}"
        tv_playTime.text = "时间：${reming[0].public_date}"
        Addneir()
        ticket_ypanxiangq.text = reming[0].intro
        ticket_shqzhank.setOnClickListener {
            if (ticket_shqzhank.text == "^展开"){
                ticket_ypanxiangq.maxLines = 100
                ticket_shqzhank.text = "^收起"
            }else{
                ticket_ypanxiangq.maxLines = 1
                ticket_shqzhank.text = "^展开"
            }
        }
        Addpingl()
        ticket_xiepingl.setOnClickListener {
            Addxiepl()
        }
        ticket_goupiao.setOnClickListener {
            val intent = Intent(this, DingzhiGoupiao::class.java)
            intent.putExtra("ID",reming[0].movie_id)
            startActivity(intent)
        }
    }

    private fun Addxiepl() {
        val builder = AlertDialog.Builder(this)
        val create = builder.create()
        val inflate = View.inflate(this, R.layout.xiepingl_tanc, null)
        create.setView(inflate)
        create.show()
        inflate.pingl_xie_fasong.setOnClickListener {
            val jsonObject = JSONObject()
            jsonObject.put("userId","admin")
            jsonObject.put("movieId",reming[0].movie_id)
            jsonObject.put("score","4")
            jsonObject.put("content",inflate.pingl_xie_neir.text)
            jsonObject.put("date","2021-05-04")
            OK.Post("/setpinglunmovie",jsonObject.toString()){
                if (it.getString("status") == "T"){
                    inflate.pingl_xie_neir.setText("")
                    create.dismiss()
                    Addneir()
                }else{
                    show(it.getString("status"))
                }
            }
        }
    }

    private fun Addpingl() {
        val jsonObject = JSONObject()
        jsonObject.put("movieId",reming[0].movie_id)
        OK.Post("/getpinglunmovie",jsonObject.toString()){
            val string = it.getString("status")
        }


    }

    private fun Addneir() {
        val jsonObject = JSONObject()
        jsonObject.put("movieId",reming[0].movie_id)
        OK.Post("/getpinglunmovie",jsonObject.toString()){
            if (it.getString("status") != "F"){
                mPinglun = Gson().fromJson(it.optString("data"),object :TypeToken<List<JabPlunyp>>(){}.type)
                ticket_yingp_pingf.text = "影片评分：${reming[0].score}，评论人数${mPinglun.size}，想看人数${reming[0].wish_num}，看过人数${reming[0].status}。"
                ticket_pingltshu.text = "${mPinglun.size}条"
                ticket_list.adapter = MyBase<JabPlunyp>(mPinglun,R.layout.pinglshuj_list){a,b,c ->
                    a.pinglshuls_neir.text = b.content
                    a.pinglshuls_time.text = b.date
                }
            }else{
                ticket_yingp_pingf.text = "影片评分：${reming[0].score}，评论人数${mPinglun.size}，想看人数${reming[0].wish_num}，看过人数${reming[0].status}。"
                ticket_pingltshu.text = "${mPinglun.size}条"
            }
        }
    }
}