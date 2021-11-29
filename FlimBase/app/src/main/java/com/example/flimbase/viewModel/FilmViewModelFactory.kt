package com.example.flimbase.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flimbase.repository.MyRepository

class FilmViewModelFactory(val repo : MyRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FilmViewModel(repo) as T
    }
}