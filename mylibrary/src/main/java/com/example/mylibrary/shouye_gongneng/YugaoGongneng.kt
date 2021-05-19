package com.example.city7_1.shouye_gongneng

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.MediaController
import android.widget.SearchView
import androidx.appcompat.app.AlertDialog
import com.example.city7_1.R
import com.example.city7_1.bean.Movie
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.show
import kotlinx.android.synthetic.main.activity_tuijian_yingyuan.*
import kotlinx.android.synthetic.main.activity_tuijian_yingyuan.iv_back
import kotlinx.android.synthetic.main.activity_yugao_gongneng.*
import kotlinx.android.synthetic.main.dialog_video.view.*
import kotlinx.android.synthetic.main.movie_list.view.*

class YugaoGongneng : AppCompatActivity(R.layout.activity_yugao_gongneng) {
    var list = mutableListOf<Movie>()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        iv_back.setOnClickListener { finish() }
        repeat(MyUity.movieList.size){i ->
            list.add(MyUity.movieList[i])
        }
        movie()
        sv_queryMovie?.let {
            it.isSubmitButtonEnabled = true
            it.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    list.clear()
                    repeat(MyUity.movieList.size){i ->
                        if(MyUity.movieList[i].name.contains(query.toString())){
                            list.add(MyUity.movieList[i])
                        }
                    }
                    it.setQuery("",false)
                    if(list.size == 0){
                        show("为搜索到相关影片")
                        return false
                    }
                    movie()
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
        }
    }

    private fun movie() {
        var _this = this
        lv_yugao?.let {
            it.adapter = MyBase<Movie>(list,R.layout.yugao_list,block = { a, b, c ->
                a.apply {
                    OK.imageView(b.poster,this.iv_movieImage)
                    this.tv_movieName.text = b.name
                }
            })
            it.setOnItemClickListener { parent, view, position, id ->
                AlertDialog.Builder(_this).let {
                    val inflate = View.inflate(this, R.layout.dialog_video, null)
                    val create = it.create()
                    create.setTitle("预告片播放")
                    create.setView(inflate)
                    create.show()
                    inflate.vv_movie?.let { a ->
                        a.setVideoURI(Uri.parse("android.resource://${packageName}/${R.raw.video02}"))
                        a.requestFocus()
                        a.start()
                        a.setOnCompletionListener {
                            create.dismiss()
                        }
                    }
                }
            }
        }
    }
}