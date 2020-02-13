package com.example.moviescodechallenge.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescodechallenge.R

class MoviesViewHolderNoData(noDataItemView: View):
        RecyclerView.ViewHolder(noDataItemView){
    val ivNoDataIcon: ImageView = noDataItemView.findViewById(R.id.iv_item_no_data_icon)
    val tvNoDataText: TextView = noDataItemView.findViewById(R.id.tv_item_no_data_message)
}