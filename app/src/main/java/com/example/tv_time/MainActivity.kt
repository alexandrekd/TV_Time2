package com.example.tv_time

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.sadistesting.RetrofitInstance
import com.example.tv_time.databinding.ActivityMainBinding
import com.example.tv_timedata.MoviesTest
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        val resultat = RetrofitInstance.movieService.getPopularMovies("9ebb909aaf76048c85007618c28b505f")
        resultat.enqueue(object : retrofit2.Callback<MoviesTest> {
            override fun onResponse(
                call: Call<MoviesTest>,
                response: Response<MoviesTest>
            ) {
                if(response.isSuccessful) {
                    Log.w("questions", ""+response.body())
                    val result = response.body()?.results
                    result?.let {
                        // use result val here
                        Log.w("sadurjanlebg", result.toString())
                        //questionIsLoad = true
                    }
                }
            }
            override fun onFailure(call: Call<MoviesTest>, t: Throwable) {
                Log.e("failed", ""+ t.message)
                Toast.makeText(this@MainActivity, "Les questions n'ont pas pu être chargé", Toast.LENGTH_SHORT).show()

            }
        })
    }



}