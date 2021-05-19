package com.example.city7_1.gerenzhongxin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.city7_1.R
import com.example.city7_1.uite.MyUity
import kotlinx.android.synthetic.main.activity_order_details.*
import kotlinx.android.synthetic.main.activity_order_list.*
import kotlinx.android.synthetic.main.activity_order_list.iv_back

class OrderDetails : AppCompatActivity(R.layout.activity_order_details) {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        val position = intent.getIntExtra("position", 0)
        tv_orderNum.text = "订单号:${MyUity.orderList[position].orderNum}"
        tv_start.text = MyUity.orderList[position].start
        tv_end.text = MyUity.orderList[position].end
        tv_orderType.text = "订单类型:智慧巴士"
        tv_orderDate.text = "订单生成日期:${MyUity.orderList[position].createTime}"
        tv_path.text = "路线:${MyUity.orderList[position].path}"
        tv_price.text = "价格:${MyUity.orderList[position].price}"
        tv_userName.text = "乘车人:${MyUity.orderList[position].userName}"
        tv_userTel.text = "手机号:${MyUity.orderList[position].userTel}"
    }
}