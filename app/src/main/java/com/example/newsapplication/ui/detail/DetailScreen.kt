package com.example.newsapplication.ui.detail

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.newsapplication.R
import com.example.newsapplication.model.Article
import org.w3c.dom.Text
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Calendar


class DetailScreen : Fragment() {

    private lateinit var newsImage : ImageView
    private lateinit var newsTitle : TextView
    private lateinit var newsAuthor : TextView
    private lateinit var newsDescription : TextView
    private lateinit var newsPublishedDate : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_detail_screen, container, false)
        newsImage = layout.findViewById(R.id.detail_news_image)
        newsTitle = layout.findViewById(R.id.detail_news_title)
        newsAuthor = layout.findViewById(R.id.detail_news_author)
        newsDescription = layout.findViewById(R.id.detail_news_description)
        newsPublishedDate = layout.findViewById(R.id.detail_news_published_date)

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDetail()
    }

    private fun getDetail() {
        val detail = arguments?.getParcelable<Article>("DATA_NEWS")


        newsTitle.text = detail!!.title
        newsAuthor.text = detail.author
        newsDescription.text = detail.description
        newsPublishedDate.text = detail.publishedAt


        Glide.with(this).load(detail.urlToImage).into(newsImage)

    }

}