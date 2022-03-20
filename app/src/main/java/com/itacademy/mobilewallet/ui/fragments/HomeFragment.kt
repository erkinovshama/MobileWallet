package com.itacademy.mobilewallet.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.itacademy.mobilewallet.App
import com.itacademy.mobilewallet.databinding.FragmentHomeBinding
import com.itacademy.mobilewallet.ui.adapters.CategoryAdapter

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbCategory = App.instance?.getDatabase()?.CategoryDao()
        val recyclerView = binding.categorySelectRecyclerview
        recyclerView.adapter = CategoryAdapter(dbCategory!!.getAllCategory(), requireActivity())
    }
}