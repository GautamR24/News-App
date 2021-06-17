package com.example.newstime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsListAdapter(private val items: ArrayList<String>, private val listener: NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
    // these are the methods of recyclerView. Adapter that needs to be implemented for Adapter
    //this function will return the view Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        // layout inflator will convert the item in xml to a view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        // setting on click listener for each item(what will happen when the item will be clicked)
        // after click whatever work we have to do, it should be done by activity not adapter
        // but how will the activity know that item is clicked? for that we use a callback which will
        // tell the allow the adapter to tell activity that an item is clicked
        // so we will create callback, for creating callback we use interfaces
        val viewHolder = NewsViewHolder(view)
        view.setOnClickListener{
            listener.onItemClicked(items[viewHolder.absoluteAdapterPosition])
        }
        return NewsViewHolder(view)
    }
    // it takes each item, puts data inside it(basically it binds)
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.titleView.text = currentItem

    }
    //how many items will be there
    override fun getItemCount(): Int {
        return items.size
    }

}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleView: TextView = itemView.findViewById(R.id.title)
}

interface NewsItemClicked{
    fun onItemClicked(item: String)
}
// for every adapter creation first create a viewholder than pass it to the adapter and implement the
// three required methods of adapter
// then connect the adapter with recyclerview present in the main acrivity