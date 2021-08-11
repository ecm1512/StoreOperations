package com.educode.examentottus.presentation.ui.home.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.educode.examentottus.databinding.FragmentHomeBinding
import com.educode.examentottus.presentation.ui.login.LoginViewModel
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : ScopeFragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textName: TextView = binding.textName
        val textMail: TextView = binding.textMail

        homeViewModel.textName.observe(viewLifecycleOwner, Observer {
            textName.text = it
        })
        homeViewModel.textMail.observe(viewLifecycleOwner, Observer {
            textMail.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}