package com.example.tv_time.ui.dashboard

import MovieAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tv_time.databinding.ActivityMainBinding
import com.example.tv_time.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var viewModel: DashboardViewModel
    private lateinit var movieAdapter : MovieAdapter
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        super.onCreate(savedInstanceState)

        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[DashboardViewModel::class.java]
        viewModel.getPopularMovies()
        viewModel.observeMovieLiveData().observe(viewLifecycleOwner, Observer { movieList ->
            movieAdapter.setMovieList(movieList)
        })

        return root
    }

    private fun prepareRecyclerView() {
        movieAdapter = MovieAdapter()
        binding.rvMovies.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = movieAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}