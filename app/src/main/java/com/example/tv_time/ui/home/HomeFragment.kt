package com.example.tv_time.ui.home

import MovieAdapter
import TvAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tv_time.databinding.FragmentDashboardBinding
import com.example.tv_time.databinding.FragmentHomeBinding
import com.example.tv_time.ui.dashboard.DashboardViewModel

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var tvAdapter : TvAdapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome

        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.getPopularTV()
        viewModel.observeTvLiveData().observe(viewLifecycleOwner, Observer { TvList ->
            tvAdapter.setTvList(TvList)
        })
        return root
    }
    private fun prepareRecyclerView() {
        tvAdapter = TvAdapter()
        binding.rvTv.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = tvAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}