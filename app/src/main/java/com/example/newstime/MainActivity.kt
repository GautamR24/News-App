 package com.example.newstime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

 class MainActivity : AppCompatActivity(), NewsItemClicked {

     private lateinit var mAdapter: NewsListAdapter

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         recyclerView.layoutManager = LinearLayoutManager(this)
         fetchData()
         mAdapter = NewsListAdapter(this)
         recyclerView.adapter = mAdapter
     }

     private fun fetchData() {
         val url = "https://saurav.tech/NewsAPI/sources.json"
         val jsonObjectRequest = JsonObjectRequest(
             Request.Method.GET,
             url,
             null,
             {
                 val newsJsonArray = it.getJSONArray("sources")
                 val newsArray = ArrayList<News>()
                 for(i in 0 until newsJsonArray.length()) {
                     val newsJsonObject = newsJsonArray.getJSONObject(i)
                     val news = News(
                         newsJsonObject.getString("name"),
                         newsJsonObject.getString("description"),
                         newsJsonObject.getString("url"),
                         //newsJsonObject.getString("urlToImage")

                     )

                     newsArray.add(news)
                 }

                 mAdapter.updateNews(newsArray)
             },
             {

             }
         )
         MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
     }

     override fun onItemClicked(item: News) {

     }
 }
