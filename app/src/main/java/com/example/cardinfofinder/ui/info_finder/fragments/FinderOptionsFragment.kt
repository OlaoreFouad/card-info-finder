package com.example.cardinfofinder.ui.info_finder.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cardinfofinder.databinding.FragmentFinderOptionsBinding

class FinderOptionsFragment : Fragment() {

    private var _binding: FragmentFinderOptionsBinding? = null
    private val binding: FragmentFinderOptionsBinding
        get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = Navigation.findNavController(container!!)
        return FragmentFinderOptionsBinding.inflate(
            inflater, container, false
        ).also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.inputCardDetailsButton.setOnClickListener {
            navController.navigate(FinderOptionsFragmentDirections.actionFinderOptionsFragment2ToInputCardDetailsFragment())
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}