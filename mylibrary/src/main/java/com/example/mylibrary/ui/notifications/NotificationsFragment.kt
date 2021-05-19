package com.example.city7_1.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.city7_1.R
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_marquee.isSelected = true
        val drawable = arrayOf(
            R.drawable.dangjian_1,
            R.drawable.dangjian_2,
            R.drawable.dangjian_3,
            R.drawable.dangjian_4
        )
        banner?.let {
            it.addBannerLifecycleObserver(this)
            it.indicator = CircleIndicator(context)
            it.adapter = object : BannerImageAdapter<Int>(drawable.toMutableList()){
                override fun onBindView(p0: BannerImageHolder?, p1: Int?, p2: Int, p3: Int) {
                    p1?.let { p0?.imageView?.setImageResource(it)}
                }
            }
        }
        tv_dangjianDongtai.setOnClickListener {  }
        tv_dangyuanXuexi.setOnClickListener {  }
        tv_zuzhiHuodong.setOnClickListener {  }
        tv_jianyanXiance.setOnClickListener {  }
        tv_suishoupai.setOnClickListener {  }
    }
}