package com.example.newsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import com.example.newsapplication.model.Article
import com.example.newsapplication.model.GetAllResponseNews

class NewsAdapter(
    private val onClick: (Article) -> Unit
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var dataNews : List<Article>? = null

    fun setDataNews(article : List<Article>){
        this.dataNews = article
    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.news_title)
        val author: TextView = itemView.findViewById(R.id.news_author)
        val description : TextView = itemView.findViewById(R.id.news_description)
        val publishedDate : TextView = itemView.findViewById(R.id.news_published_date)
        val imageNews: ImageView = itemView.findViewById(R.id.news_image)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_adapter, parent, false)


        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dataNews!![position].title
        holder.author.text = dataNews!![position].author
        holder.description.text = dataNews!![position].description
        holder.publishedDate.text = dataNews!![position].publishedAt

        Glide.with(holder.itemView.context).load(dataNews!![position].urlToImage).into(holder.imageNews)
//
//        holder.itemView.cardNews.setOnClickListener {
//            onClick(dataNews[position])
//        }
    }

    override fun getItemCount(): Int {
        return dataNews?.size ?: 0
    }
}