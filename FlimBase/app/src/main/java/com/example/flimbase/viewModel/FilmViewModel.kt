package com.example.flimbase.viewModel

import androidx.lifecycle.ViewModel
import com.example.flimbase.repository.MyRepository

class FilmViewModel(val repo : MyRepository) : ViewModel() {
    fun getFilmFromApi(){
        repo.getRemoteMovie()
    }
}