package com.example.city7_1.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.city7_1.R
import com.example.city7_1.ShouyeXiangqyem
import com.example.city7_1.bean.Jabjijshangy
import com.example.city7_1.bean.Movie
import com.example.city7_1.bean.YingYuan
import com.example.city7_1.goup.GoupiaoJieshao
import com.example.city7_1.shouye_gongneng.TuijianYingyuan
import com.example.city7_1.shouye_gongneng.XingwenYemian
import com.example.city7_1.shouye_gongneng.YingpianPinglun
import com.example.city7_1.shouye_gongneng.YugaoGongneng
import com.example.city7_1.uite.MyBase
import com.example.city7_1.uite.MyUity
import com.example.city7_1.uite.OK
import com.example.city7_1.uite.request
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.movie_list.view.*
import kotlinx.android.synthetic.main.movie_list.view.rb_score
import kotlinx.android.synthetic.main.reyingypan_list.view.*
import kotlinx.android.synthetic.main.ying_yuan_list.view.*
import kotlinx.android.synthetic.main.yingyfuw_list.view.*
import org.json.JSONObject

@RequiresApi(Build.VERSION_CODES.R)
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var root:View
    val mWidth by lazy {
        context!!.display!!.width
    }
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Lunbot()
        XianshiTqi()
        Yingyfuw()
        Remenyingp()
        JijiangShangy()
        Yingyuan()
    }

    private fun Yingyuan() {
        if (MyUity.yingYuanList.size == 0){
            val jsonObject = JSONObject()
            jsonObject.put("city","广州")
            OK.Post("/wherecinema",jsonObject.toString(),block = {
                it.request("data",MyUity.yingYuanList)
                activity?.runOnUiThread { yingYuanAdapter() }
            })
        }else yingYuanAdapter()
    }

    private fun yingYuanAdapter() {
        root.fra1_zhoubianyyuan?.let {
            it.adapter = MyBase<YingYuan>(MyUity.yingYuanList,R.layout.ying_yuan_list,block = { a, b, c ->
                a.apply {
                    this.iv_yingYuanImage.setImageResource(R.drawable.ying_yuan_feng_mian)
                    this.tv_yingYuanName.text = b.cinema_name
                    this.tv_address.text = b.specified_address
                    this.rb_score.rating = b.score.toFloat()
                    this.setOnClickListener {
                        val intent = Intent(requireContext(), ShouyeXiangqyem::class.java)
                        intent.putExtra("xqzhoub",b)
                        intent.putExtra("IDD",3)
                        startActivity(intent)
                    }
                }
            })
        }
    }

    private fun JijiangShangy() {
        if(MyUity.qJijiangshying.size == 0) {
            OK.GetKey("/commingmovies",block = {
                it.request("data",MyUity.qJijiangshying)
                activity?.runOnUiThread { JijsyAdapter() }
            })
        } else JijsyAdapter()
    }

    private fun JijsyAdapter() {
        root.fra1_jijiangshangy.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = object :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
                override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): RecyclerView.ViewHolder {
                    return object:RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.reyingypan_list,parent,false)){}
                }

                override fun getItemCount(): Int {
                    return MyUity.qJijiangshying.size
                }

                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    val layoutParams = LinearLayout.LayoutParams(
                        mWidth / 3,
                        LinearLayout.LayoutParams.MATCH_PARENT
                    )
                    holder.itemView.layoutParams = layoutParams
                    MyUity.qJijiangshying[position].let {b ->
                        holder.itemView.run {
                            OK.imageView(b.poster,this.reyingls_tupian)
                            this.reyingls_name.text = b.name
                            this.reyingls_anniu.text = "想看"
                            this.setOnClickListener {
                                val intent = Intent(requireContext(), ShouyeXiangqyem::class.java)
                                intent.putExtra("xqshangy",b)
                                intent.putExtra("IDD",2)
                                startActivity(intent)
                            }
                        }
                    }
                }

            }
        }
    }

    private fun Remenyingp() {
        if(MyUity.movieList.size == 0) {
            OK.GetKey("/hotmovies",block = {
                it.request("data",MyUity.movieList)
                activity?.runOnUiThread { movieAdapter() }
            })
        } else movieAdapter()
    }


    private fun movieAdapter() {
        root.fra1_reyingyyuan.run {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = object : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
                    return object : RecyclerView.ViewHolder(layoutInflater.inflate(R.layout.reyingypan_list,parent,false)){}
                }

                override fun getItemCount(): Int {
                    return MyUity.movieList.size
                }
                override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
                    val layoutManager = LinearLayout.LayoutParams(mWidth/3,LinearLayout.LayoutParams.MATCH_PARENT)
                    holder.itemView.layoutParams = layoutManager
                    MyUity.movieList[position].let { b->
                        holder.itemView.run {
                            OK.imageView(b.poster,this.reyingls_tupian)
                            this.reyingls_name.text = b.name
                            this.reyingls_anniu.setOnClickListener {
                                val intent = Intent(requireContext(),GoupiaoJieshao::class.java)
                                intent.putExtra("reying",b)
                                startActivity(intent)
                            }
                            this.setOnClickListener {
                                val intent = Intent(requireContext(), ShouyeXiangqyem::class.java)
                                intent.putExtra("xqreying",b)
                                intent.putExtra("IDD",1)
                                startActivity(intent)
                            }
                        }
                    }
                }

            }
        }
    }

    private fun Yingyfuw() {
        val mutableListOf = mutableListOf<JabYingyfuw>()
        mutableListOf.add(JabYingyfuw(R.drawable.tubiao,"推荐"))
        mutableListOf.add(JabYingyfuw(R.drawable.tubiao,"预告"))
        mutableListOf.add(JabYingyfuw(R.drawable.tubiao,"影评"))
        mutableListOf.add(JabYingyfuw(R.drawable.tubiao,"星闻"))
        root.fra1_yingygongn.adapter = MyBase<JabYingyfuw>(mutableListOf,R.layout.yingyfuw_list){a,b,c ->
            a.yingyfuw_list_name.text = b.name
            a.yingyfuw_list_tup.setImageResource(b.tup)
        }
        root.fra1_yingygongn.numColumns = 4
        root.fra1_yingygongn.setOnItemClickListener { parent, view, position, id ->
            when(position){
                0 -> startActivity(Intent(context, TuijianYingyuan::class.java))
                1 -> startActivity(Intent(context, YugaoGongneng::class.java))
                2 -> startActivity(Intent(context, YingpianPinglun::class.java))
                3 -> startActivity(Intent(context, XingwenYemian::class.java))
            }
        }
    }

    private fun XianshiTqi() {
        if (MyUity.qWendPaomd.isEmpty()){
            OK.GetKey("/weather"){
                val jsonObject = it.getJSONObject("data")
                MyUity.qWendPaomd = jsonObject.toString()
                root.fra1_tianq_paomad.text = MyUity.qWendPaomd
                root.fra1_tianq_paomad.isSelected = true
            }
        }else{
            root.fra1_tianq_paomad.text = MyUity.qWendPaomd
            root.fra1_tianq_paomad.isSelected = true
        }
    }

    private fun Lunbot() {
        if (MyUity.qzhuylunbt.size == 0){
            OK.doGet("/userinfo/rotation/list?pageNum=1&pageSize=10&type=45"){
                val jsonArray = it.getJSONArray("rows")
                for (i in 0 until jsonArray.length()) {
                    MyUity.qzhuylunbt.add(jsonArray.getJSONObject(i).getString("imgUrl"))
                }
                CaozLunbot()
            }
        }else CaozLunbot()
    }
    private fun CaozLunbot() {
        root.fra1_lunbtu.adapter = object :BannerImageAdapter<String>(MyUity.qzhuylunbt){
            override fun onBindView(p0: BannerImageHolder?, p1: String?, p2: Int, p3: Int) {
                p0?.imageView?.let {
                    if (p1 != null) OK.doImageView(p1,it)
                }
            }
        }
    }
}
data class JabYingyfuw(var tup:Int,var name:String)