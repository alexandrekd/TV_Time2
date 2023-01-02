package com.example.tv_time.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sadistesting.RetrofitInstance
import com.example.tv_timedata.MoviesTest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    private var movieLiveData = MutableLiveData<List<com.example.tv_timedata.Result>>()
    fun getPopularMovies() {
        RetrofitInstance.movieService.getPopularMovies("9ebb909aaf76048c85007618c28b505f").enqueue(object  :
            Callback<MoviesTest> {
            override fun onResponse(call: Call<MoviesTest>, response: Response<MoviesTest>) {
                if (response.body()!=null){
                    movieLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<MoviesTest>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeMovieLiveData() : LiveData<List<com.example.tv_timedata.Result>> {
        return movieLiveData
    }
}