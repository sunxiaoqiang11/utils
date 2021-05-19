package com.example.city7_1.goup

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.city7_1.R
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.show
import kotlinx.android.synthetic.main.activity_xuanzecuow.*
import kotlinx.android.synthetic.main.erweima_tanc.view.*
import kotlinx.android.synthetic.main.tubiaozuow_list.view.*
import kotlin.math.ceil

data class JabXuanzuo(var neir:Int,var pand:Boolean)

class Xuanzecuow : Activity() {
    var pandua:Boolean = false
    val xunhuan = mutableListOf<JabXuanzuo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xuanzecuow)
        nexuanzzuow_fanh.setOnClickListener { finish() }
        for (i in 0..29){
            xunhuan.add(JabXuanzuo(i,false))
        }
        Addzuow()
        nexuanzzuow_qued.setOnClickListener {
            for (i in 0 until xunhuan.size){
                if (xunhuan[i].pand){
                    pandua = true
                }
            }
            if (pandua){
                Addshuju()
            }else{
                show("请选择座位")
            }
        }
    }

    private fun Addshuju() {
        val builder = AlertDialog.Builder(this)
        val create = builder.create()
        val inflate = View.inflate(this, R.layout.erweima_tanc, null)
        create.setView(inflate)
        create.show()
        inflate.erweima_tanc_qd.setOnClickListener { create.dismiss() }
    }

    private fun Addzuow() {
        nexuanzzuow_list.adapter = MyBase<JabXuanzuo>(xunhuan,R.layout.tubiaozuow_list){a,b,c ->
            a.zuoweixz_biak.text = "${b.neir}"
            a.zuoweixz_biak.setOnClickListener {
                if (b.pand){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        a.zuoweixz_biak.setBackgroundColor(getColor(R.color.huise))
                    }
                    xunhuan[c].pand = false
                }else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        a.zuoweixz_biak.setBackgroundColor(getColor(R.color.hongse))
                    }
                    xunhuan[c].pand = true
                }
            }
        }
        nexuanzzuow_list.numColumns = 6
    }

}