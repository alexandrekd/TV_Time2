package com.example.tv_time.ui.moviePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tv_time.databinding.FragmentFilmPageBinding
import com.example.tv_time.databinding.FragmentProfilBinding
import com.example.tv_time.ui.notifications.NotificationsViewModel

class MoviePageFragment : Fragment(){

    private var _binding: FragmentFilmPageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val MoviePageViewModel =
            ViewModelProvider(this).get(MoviePageViewModel::class.java)

        _binding = FragmentFilmPageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}