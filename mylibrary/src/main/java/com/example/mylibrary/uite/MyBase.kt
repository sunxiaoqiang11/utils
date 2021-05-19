package com.example.city7_1.uite

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MyBase<T>(var gather:List<T>,var layou:Int,var block:(View,T,Int)->Unit) :BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View? = null
        if (view == null){
            view = View.inflate(parent?.context,layou,null)
        }else view = convertView
        view?.let { block(it,gather[position],position) }
        return view!!
    }

    override fun getItem(position: Int): T {
        return gather[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return gather.size
    }

}