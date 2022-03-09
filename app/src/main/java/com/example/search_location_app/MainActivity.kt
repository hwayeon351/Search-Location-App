package com.example.search_location_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.search_location_app.databinding.ActivityMainBinding
import com.example.search_location_app.model.LocationLatLngEntity
import com.example.search_location_app.model.SearchResultEntity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var searchRecyclerAdapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initViews()
        setData()

    }

    private fun initAdapter() {
        searchRecyclerAdapter = SearchRecyclerAdapter {
            Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViews() = with(binding) {
        emptyResultTextView.isVisible = false
        recyclerView.adapter = searchRecyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun setData() {
        val dataList = (0..10).map {
            SearchResultEntity(
                name = "빌딩 $it",
                fullAddress = "주소 $it",
                locationLatLng = LocationLatLngEntity(
                    it.toFloat(),
                    it.toFloat()
                )
            )
        }
        searchRecyclerAdapter.submitList(dataList)
    }


}