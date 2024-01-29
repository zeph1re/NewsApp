package com.example.newsapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import com.example.newsapplication.model.Article

class HeadlinesAdapter(
    private val onClick: (Article) -> Unit
) : RecyclerView.Adapter<HeadlinesAdapter.ViewHolder>() {

    private var dataHeadlines : List<Article>? = null

    fun setDataHeadlines(article : List<Article>){
        this.dataHeadlines = article
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val headlineTitle : TextView = itemView.findViewById(R.id.headlines_title)
        val headlinesImage : ImageView = itemView.findViewById(R.id.headlines_image)
        val headlinesAuthor : TextView = itemView.findViewById(R.id.headlines_author)
        val headlinesCard : CardView = itemView.findViewById(R.id.headlines_card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.headlines_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataHeadlines?.size ?: 0

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.headlineTitle.text = dataHeadlines!![position].title
        holder.headlinesAuthor.text = dataHeadlines!![position].author

        Glide.with(holder.itemView.context).load(dataHeadlines!![position].urlToImage).into(holder.headlinesImage)

        holder.headlinesCard.setOnClickListener {
            onClick(dataHeadlines!![position])
        }
    }
}