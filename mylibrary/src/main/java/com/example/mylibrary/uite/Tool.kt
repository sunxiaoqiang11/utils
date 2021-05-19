package com.example.city7_1.uite

import android.widget.Toast
import com.google.gson.Gson
import org.json.JSONObject

private var toast = Toast.makeText(MyUity.context,"",Toast.LENGTH_SHORT)

fun show(msg:String){
    toast.cancel()
    toast = Toast.makeText(MyUity.context,msg,Toast.LENGTH_SHORT)
    toast.show()
}

inline fun <reified T> JSONObject.request(data:String, list:MutableList<T>){
    val jsonArray = getJSONArray(data)
    repeat(jsonArray.length()){
        list.add(Gson().fromJson(jsonArray[it].toString(),T::class.java))
    }
}

