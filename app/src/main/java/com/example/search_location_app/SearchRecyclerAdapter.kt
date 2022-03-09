package com.example.search_location_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.search_location_app.databinding.ItemSearchResultBinding
import com.example.search_location_app.model.SearchResultEntity

class SearchRecyclerAdapter(private val searchResultClickListener: (SearchResultEntity) -> Unit): ListAdapter<SearchResultEntity, SearchRecyclerAdapter.ViewHolder> (diffUtil) {

    inner class ViewHolder(private val binding: ItemSearchResultBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: SearchResultEntity) = with(binding) {
            titleTextView.text = "제목"
            subtextTextView.text = "부제목"
        }

        fun bindViews(data: SearchResultEntity) {
            binding.root.setOnClickListener {
                searchResultClickListener(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(currentList[position])
        holder.bindViews(currentList[position])
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<SearchResultEntity>() {
            override fun areItemsTheSame(oldItem: SearchResultEntity, newItem: SearchResultEntity): Boolean {
                TODO("Not yet implemented")
            }

            override fun areContentsTheSame(oldItem: SearchResultEntity, newItem: SearchResultEntity): Boolean {
                TODO("Not yet implemented")
            }

        }
    }

}