package com.example.moviescodechallenge.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviescodechallenge.R
import kotlinx.android.synthetic.main.item_layout.view.*

class MoviesViewHolder (itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val tvGenre: TextView = itemView.findViewById(R.id.tv_item_genre)
        val ivPoster: ImageView = itemView.findViewById(R.id.iv_item_poster)
}