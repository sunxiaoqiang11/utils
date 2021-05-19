package com.example.city7_1.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.city7_1.R
import com.example.city7_1.bean.Movie
import com.example.city7_1.goup.GoupiaoJieshao
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.request
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.movie_list.*
import kotlinx.android.synthetic.main.movie_list.view.*
import kotlinx.android.synthetic.main.movie_list.view.bt_goPiao
import kotlinx.android.synthetic.main.reyingypan_list.view.*


class MovieFragment : Fragment(R.layout.fragment_movie) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter()
    }

    @SuppressLint("SetTextI18n")
    private fun movieAdapter() {
        lv_movie?.let {
            it.adapter = MyBase<Movie>(MyUity.movieList,R.layout.movie_list,block = {a,b,c ->
                a.apply {
                    OK.imageView(b.poster,this.iv_movieImage)
                    this.tv_movieName.text = b.name
                    this.tv_movieType.text = "类型:${b.type}"
                    this.tv_playTime.text = "播放时间:${b.movie_long}"
                    this.rb_score.rating = b.score
                    this.bt_goPiao.setOnClickListener {
                        val intent = Intent(requireContext(), GoupiaoJieshao::class.java)
                        intent.putExtra("reying",b)
                        startActivity(intent)
                    }
                }
            })

        }
    }
}