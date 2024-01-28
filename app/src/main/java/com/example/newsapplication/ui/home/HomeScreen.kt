package com.example.newsapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.R
import com.example.newsapplication.model.Article
import com.example.newsapplication.network.ApiClient
import com.example.newsapplication.ui.adapter.NewsAdapter
import retrofit2.Call
import java.lang.Error
import javax.security.auth.callback.Callback

class HomeScreen : Fragment() {

    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_screen, container, false)
        newsRecyclerView = view.findViewById(R.id.newsRv)
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getNews()
        initRv()

    }

    private fun initRv() {
        newsRecyclerView.layoutManager = LinearLayoutManager(context)
        newsAdapter = NewsAdapter {
            val clickedNews = bundleOf("DATA_NEWS" to it)
            Navigation.findNavController(requireView()).navigate(R.id.action_homeScreen_to_detailScreen, clickedNews)
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
        }

        newsRecyclerView.adapter = newsAdapter
    }

    private fun getNews() {
        try {
            homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

            homeViewModel.newsData.observe(viewLifecycleOwner){
                if (it != null){
                    newsAdapter.setDataNews(it.articles)
                    newsAdapter.notifyDataSetChanged()
                    Log.d("getNews", "getNews: ${it.articles}")
                }
            }

            homeViewModel.getAllNews()
        } catch (e : Error){
            Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
        }

    }


}