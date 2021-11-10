package com.example.cardinfofinder.ui.info_finder.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cardinfofinder.databinding.FragmentInputCardDetailsBinding

class InputCardDetailsFragment : Fragment() {

    private var _binding: FragmentInputCardDetailsBinding? = null
    val binding: FragmentInputCardDetailsBinding
        get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = Navigation.findNavController(container!!)
        return FragmentInputCardDetailsBinding.inflate(
            inflater, container, false
        ).also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.checkCardDetailsButton.setOnClickListener {
            val cardNumber = binding.cardNumberInput.rawText.toString()
            if (cardNumber.length < 8) {
                Toast.makeText(requireContext(), "Please enter up to 8 characters", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(requireContext(), cardNumber, Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}