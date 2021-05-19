package com.example.city7_1.gerenzhongxin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.R
import com.example.city7_1.bean.Order
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.request
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_order_list.*
import kotlinx.android.synthetic.main.order_list.view.*

class OrderList : AppCompatActivity(R.layout.activity_order_list) {
    val orders = mutableListOf<Order>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        tl_pay.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
                adapter(p0?.position)
            }
        })
        data()
    }

    @SuppressLint("SetTextI18n")
    private fun data() {
        OK.doGetKey("/userinfo/orders/list?userId=${MyUity.user?.userId}",block = {
            it.request("data",orders)
            runOnUiThread {
                adapter(0)
            }
        })
    }

    private fun adapter(status: Int?) {
        MyUity.orderList.clear()
        repeat(orders.size){i ->
            if(orders[i].status == status){
                MyUity.orderList.add(orders[i])
            }
        }
        lv_pay?.let {
            it.adapter = MyBase<Order>(MyUity.orderList,R.layout.order_list,block = {a,b,c ->
                a.apply {
                    this.tv_orderNum.text = "订单号:${b.orderNum}"
                    this.tv_orderType.text = "订单类型:智慧巴士"
                    this.tv_orderDate.text = "订单生成日期:${b.createTime}"
                }
            })
            it.setOnItemClickListener { parent, view, position, id ->
                Intent(this,OrderDetails::class.java).apply {
                    putExtra("position",position)
                    startActivity(this)
                }
            }
        }
    }
}