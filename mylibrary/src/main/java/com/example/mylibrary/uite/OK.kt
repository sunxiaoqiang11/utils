package com.example.city7_1.uite

import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

object OK{
    fun doGet(urls:String,block:(JSONObject) -> Unit){
        val build = Request.Builder().url(MyUity.Urls + urls).get().build()
        OkHttpClient().newCall(build).enqueue(MyCall(block))
    }
    fun doGetKey(urls:String,block:(JSONObject) -> Unit){
        val build = Request.Builder().url(MyUity.Urls + urls).addHeader("Authorization",MyUity.toKey).get().build()
        OkHttpClient().newCall(build).enqueue(MyCall(block))
    }
    fun GetKey(urls:String,block:(JSONObject) -> Unit){
        val build = Request.Builder().url(MyUity.Urls_1 + urls).addHeader("Authorization",MyUity.toKey).get().build()
        OkHttpClient().newCall(build).enqueue(MyCall(block))
    }
    fun doImageView(urls: String,imageView: ImageView){
        Glide.with(imageView).load(MyUity.Urls+urls).into(imageView)
    }
    fun imageView(urls: String,imageView: ImageView){
        Glide.with(imageView).load(MyUity.Urls_1+urls).into(imageView)
    }
    fun doPost(urls:String,jsons:String,block:(JSONObject) -> Unit){
        val create = RequestBody.create(MediaType.parse("application/json;charser=utf-8"), jsons)
        val build = Request.Builder().url(MyUity.Urls + urls).addHeader("Authorization",MyUity.toKey).post(create).build()
        OkHttpClient().newCall(build).enqueue(MyCall(block))
    }
    fun Post(urls:String,jsons:String,block:(JSONObject) -> Unit){
        val create = RequestBody.create(MediaType.parse("application/json;charser=utf-8"), jsons)
        val build = Request.Builder().url(MyUity.Urls_1 + urls).addHeader("Authorization",MyUity.toKey).post(create).build()
        OkHttpClient().newCall(build).enqueue(MyCall(block))
    }
    fun doPut(urls:String,jsons:String,block:(JSONObject) -> Unit){
        val create = RequestBody.create(MediaType.parse("application/json;charser=utf-8"), jsons)
        val build = Request.Builder().url(MyUity.Urls + urls).addHeader("Authorization",MyUity.toKey).put(create).build()
        OkHttpClient().newCall(build).enqueue(MyCall(block))
    }
    fun doMublit(urls:String,jsons:MultipartBody,block:(JSONObject) -> Unit){
        val build = Request.Builder().url(MyUity.Urls + urls).addHeader("Authorization",MyUity.toKey).post(jsons).build()
        OkHttpClient().newCall(build).enqueue(MyCall(block))
    }
    private class MyCall(var block: (JSONObject) -> Unit): Callback {
        override fun onFailure(p0: Call, p1: IOException) {

            p1.printStackTrace()
        }

        override fun onResponse(p0: Call, p1: Response) {
            val jsonObject = JSONObject(p1.body()?.string())
            MainScope().launch {
                block(jsonObject)
            }
        }

    }
}