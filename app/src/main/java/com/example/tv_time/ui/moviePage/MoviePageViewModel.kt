package com.example.tv_time.ui.moviePage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoviePageViewModel : ViewModel(){

    private val _text = MutableLiveData<String>().apply {
        value = "This is profil Fragment"
    }
    val text: LiveData<String> = _text
}