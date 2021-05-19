package com.example.city7_1.goup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.city7_1.R
import com.example.city7_1.bean.JabYingpgpxz
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_dingzhi_goupiao.*
import kotlinx.android.synthetic.main.activity_dingzhi_goupiao.iv_movieImage
import kotlinx.android.synthetic.main.activity_dingzhi_goupiao.tv_movieName
import kotlinx.android.synthetic.main.activity_dingzhi_goupiao.tv_movieType
import kotlinx.android.synthetic.main.activity_dingzhi_goupiao.tv_playTime
import kotlinx.android.synthetic.main.activity_goupiao_jieshao.*
import kotlinx.android.synthetic.main.xuanzedata_list.view.*
import kotlinx.android.synthetic.main.xuanzeyingy_list.view.*
import org.json.JSONObject

class DingzhiGoupiao : Activity() {
    var reming = mutableListOf<JabYingpgpxz>()
    var Linshibl = mutableListOf<JabYingpgpxz>()
    var intEdshu = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dingzhi_goupiao)
        intEdshu = intent.getIntExtra("ID", -1)
        if (intEdshu != -1){
            Addshuj()
        }
        xuanzeyingy_fanh.setOnClickListener { finish() }
    }

    private fun Addshuj() {
        val jsonObject = JSONObject()
        jsonObject.put("movieId",intEdshu)
        OK.Post("/getCinemaMovies", jsonObject.toString()) {
            reming = Gson().fromJson(it.optString("data"), object : TypeToken<List<JabYingpgpxz>>() {}.type)
            if (reming.size != 0) {
                xuanzeyingy_list.adapter =
                    MyBase<JabYingpgpxz>(reming, R.layout.xuanzeyingy_list) { a, b, c ->
                        a.xuanzyyls_jiage.text = "${b.price}元"
                        a.xuanzyyls_name.text = "${b.brand}"
                        a.xuanzyyls_dizhi.text = "${b.specified_address}"
                        a.setOnClickListener {
                            val intent = Intent(
                                this@DingzhiGoupiao,
                                ChangCiXuanze::class.java
                            )
                            intent.putExtra("jihe",b)
                            startActivity(intent)
                        }
                    }
                Addneir()
            }
        }
    }

    private fun Addneir() {
        OK.imageView(reming[0].poster, iv_movieImage)
        tv_movieName.text = reming[0].name
        tv_movieType.text = "类型：${reming[0].type},评分：${reming[0].score}"
        tv_playTime.text = "时间：${reming[0].public_date}"
        tv_nei.let {
            it.text = "时长：${reming[0].movie_long}"
        }
        Addtime()
    }

    private fun Addtime() {
        val mutableSetOf = mutableSetOf<String>()
        mutableSetOf.add("全部")
        if (reming.size != 0){
            mutableSetOf.add(reming.get(0).show_date)
        }
        for (jabYingpgpxz in reming) {
            mutableSetOf.add(jabYingpgpxz.show_date)
        }
        if (mutableSetOf.size != 0){
            xuanzeyingy_xuanzriq.run {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                this.adapter = object:RecyclerView.Adapter<RecyclerView.ViewHolder>(){
                    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RecyclerView.ViewHolder {
                        return object:RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.xuanzedata_list,parent,false)){}
                    }

                    override fun getItemCount(): Int {
                        return mutableSetOf.size
                    }

                    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                        mutableSetOf.let { b->
                            holder.itemView.run {
                                this.xuanzedatals_name.text = b.elementAt(position)
                                this.xuanzedatals_name.setOnClickListener {
                                    when(b.elementAt(position)){
                                        "全部" -> {
                                            xuanzeyingy_list.adapter = MyBase<JabYingpgpxz>(reming, R.layout.xuanzeyingy_list) { a, b, c ->
                                                a.xuanzyyls_jiage.text = "${b.price}元"
                                                a.xuanzyyls_name.text = "${b.brand}"
                                                a.xuanzyyls_dizhi.text = "${b.specified_address}"
                                                a.setOnClickListener {
                                                    val intent = Intent(
                                                        this@DingzhiGoupiao,
                                                        ChangCiXuanze::class.java
                                                    )
                                                    intent.putExtra("jihe",b)
                                                    startActivity(intent)
                                                }
                                                }
                                        }
                                        else->{//Linshibl
                                            Linshibl.clear()
                                            repeat(reming.size){
                                                if (b.elementAt(position) == reming[it].show_date){
                                                    Linshibl.add(reming[it])
                                                }
                                            }
                                            if (Linshibl.size != 0){
                                                xuanzeyingy_list.adapter = MyBase<JabYingpgpxz>(Linshibl, R.layout.xuanzeyingy_list) { a, b, c ->
                                                    a.xuanzyyls_jiage.text = "${b.price}元"
                                                    a.xuanzyyls_name.text = "${b.brand}"
                                                    a.xuanzyyls_dizhi.text = "${b.specified_address}"
                                                    a.setOnClickListener {
                                                        val intent = Intent(
                                                            this@DingzhiGoupiao,
                                                            ChangCiXuanze::class.java
                                                        )
                                                        intent.putExtra("jihe",b)
                                                        startActivity(intent)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}