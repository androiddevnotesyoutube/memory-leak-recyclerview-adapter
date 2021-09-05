package com.androiddevnotes.memoryleakrecyclerviewadapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.androiddevnotes.memoryleakrecyclerviewadapter.databinding.FragmentListA1Binding

/** Fragment containing RecyclerView */
class A1ListFragment : Fragment(), A1ListRecyclerViewAdapter.OnA1ListItemClickedListener {

    private var _binding: FragmentListA1Binding? = null
    private val binding get() = _binding!!

    // Making RecyclerView adapter nullable so we could set it to null in onDestroyView
    private var a1ListRecyclerViewAdapter: A1ListRecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListA1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        a1ListRecyclerViewAdapter = A1ListRecyclerViewAdapter(this)
        binding.a1ListRecyclerView.adapter = a1ListRecyclerViewAdapter
    }

    override fun onDestroyView() {
        // Important to set fields to `null` to prevent memory leaks.
        // We are setting fields to null before `super.onDestroyView()` because official ViewBinding
        // sample, Mozilla Fenix app also do that. I do not know the exact reason.

        // a1ListRecyclerViewAdapter = null
        _binding = null
        super.onDestroyView()
    }

    override fun onA1ListItemClicked() {
        findNavController().navigate(R.id.action_a1ListFragment_to_a2DetailFragment)
    }
}