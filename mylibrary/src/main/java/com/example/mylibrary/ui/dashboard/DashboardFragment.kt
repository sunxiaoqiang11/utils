package com.example.city7_1.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.city7_1.R
import com.example.city7_1.bean.YingYuan
import com.example.city7_1.goup.DingzhiGoupiao
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.request
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.ying_yuan_list.view.*
import org.json.JSONObject

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    val mutableListOf = mutableListOf<YingYuan>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        MyUity.yingYuanList.clear()
        yingYuan()

        sv_queryYingYuan?.let {
            it.isSubmitButtonEnabled = true
            it.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    MyUity.yingYuanList.clear()
                    yingYuanAdapter(query.toString(),1)
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

            })
        }
    }

    private fun yingYuan() {
        val jsonObject = JSONObject()
        jsonObject.put("city","广州")
        OK.Post("/wherecinema",jsonObject.toString(),block = {
            it.request("data",MyUity.yingYuanList)
            it.request("data",mutableListOf)
            activity?.runOnUiThread { yingYuanAdapter("#",0) }
        })
    }

    private fun yingYuanAdapter(query:String,a:Int) {
        if(a == 1){
            repeat(mutableListOf.size){j ->
                if(mutableListOf[j].cinema_name.contains(query)){
                    MyUity.yingYuanList.add(mutableListOf[j])
                }
            }
        }
        lv_yingYuan?.let {
            it.adapter = MyBase<YingYuan>(MyUity.yingYuanList,R.layout.ying_yuan_list,block = {a,b,c ->
                a.apply {
                    this.iv_yingYuanImage.setImageResource(R.drawable.ying_yuan_feng_mian)
                    this.tv_yingYuanName.text = b.cinema_name
                    this.tv_address.text = b.specified_address
                    this.rb_score.rating = b.score.toFloat()
                }
            })
            it.setOnItemClickListener { parent, view, position, id ->
                Intent(context, YingyuanXuanze::class.java).apply {
                    putExtra("position",position)
                    startActivity(this)
                }

            }
        }
    }
}