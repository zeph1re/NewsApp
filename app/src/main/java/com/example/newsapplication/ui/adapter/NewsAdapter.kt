package com.example.newsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.model.Article

class NewsAdapter(
    private var dataNews : List<Article>,
    private val onClick: (Article) -> Unit
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTV = itemView.findViewById<TextView>(R.id.title_tv)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_adapter, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTV.text = dataNews[position].title
//        holder.itemView.tv_tanggal_rilis.text = dataNews[position].createdAt
//        holder.itemView.tv_penulis.text = dataNews[position].author
//
//        Glide.with(holder.itemView.context).load(dataNews[position].image).into(holder.itemView.image_news)
//
//        holder.itemView.cardNews.setOnClickListener {
//            onClick(dataNews[position])
//        }
    }

    override fun getItemCount(): Int {
        return dataNews.size
    }
}