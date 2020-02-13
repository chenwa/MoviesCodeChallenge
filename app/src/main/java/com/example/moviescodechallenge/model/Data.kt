package com.example.moviescodechallenge.model

import androidx.room.Entity

@Entity(tableName = "movies_table")
data class Data (
    var title: String,
    var year: String,
    var genre: String,
    var poster: String
)