package com.androiddevnotes.memoryleakrecyclerviewadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androiddevnotes.memoryleakrecyclerviewadapter.databinding.FragmentDetailA2Binding

/**
 * Detail fragment which will open once an item is clicked in a
 * RecyclerView.
 */
class A2DetailFragment : Fragment() {

    private var _binding: FragmentDetailA2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailA2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}