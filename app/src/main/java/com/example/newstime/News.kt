package com.example.newstime

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

// we will pass this array to adapter class
data class News(
    val name:String,
    val description:String,
    val url: String
)


//val url =
//    "https://saurav.tech/NewsAPI/sources.json"
////making a request
//val jsonObjectRequest = object : JsonObjectRequest(
//    Request.Method.GET,
//    url,
//    null,
//    Response.Listener {
//        val newsJsonArray = it.getJSONArray("sources")
//        val newsArray = ArrayList<News>()
//        for (i in 0 until newsJsonArray.length()) {
//            val newsJsonObject = newsJsonArray.getJSONObject(i)
//            val news = News(
//                newsJsonObject.getString("name"),
//                newsJsonObject.getString("description"),
//                newsJsonObject.getString("url"),
//                //newsJsonObject.getString("urlToImage")
//            )
//            newsArray.add(news)
//        }
//
//        mAdapter.updateNews(newsArray)
//    }