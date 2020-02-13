package com.example.moviescodechallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviescodechallenge.model.PokoMovieList

class MoviesViewModel : ViewModel(){
    // TODO: show all movies
    // TODO: recieves
    // TODO: show all movies
    // TODO: show all movies

    // network call -> checks cache -> if cache empty
    // save into room DB ->

    private val errorMessage = MutableLiveData<String>()
    private val dataMovieList = MutableLiveData<PokoMovieList>()

    fun getErrorMessage(): LiveData<String> = errorMessage
    fun getDataMovieList(): LiveData<PokoMovieList> = dataMovieList
}