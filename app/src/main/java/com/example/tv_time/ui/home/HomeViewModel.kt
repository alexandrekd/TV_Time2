package com.example.tv_time.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sadistesting.RetrofitInstance
import com.example.tv_time.ResultTv
import com.example.tv_time.TvTest
import com.example.tv_timedata.MoviesTest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = ""
    }
    val text: LiveData<String> = _text

    private var TvLiveData = MutableLiveData<List<ResultTv>>()
    fun getPopularTV() {
        RetrofitInstance.movieService.getPopularTV("9ebb909aaf76048c85007618c28b505f").enqueue(object  :
            Callback<TvTest> {
            override fun onResponse(call: Call<TvTest>, response: Response<TvTest>) {
                if (response.body()!=null){
                    TvLiveData.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<TvTest>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }
    fun observeTvLiveData() : LiveData<List<ResultTv>> {
        return TvLiveData
    }
}