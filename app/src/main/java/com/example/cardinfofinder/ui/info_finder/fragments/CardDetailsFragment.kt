package com.example.cardinfofinder.ui.info_finder.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.cardinfofinder.databinding.FragmentCardDetailsBinding

class CardDetailsFragment : Fragment() {

    private var _binding: FragmentCardDetailsBinding? = null
    val binding: FragmentCardDetailsBinding
        get() = _binding!!

    private lateinit var navController: NavController

    private val args: CardDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        navController = Navigation.findNavController(container!!)
        return FragmentCardDetailsBinding.inflate(
            inflater, container, false
        ).also { _binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardBank.text = args.details.bank
        binding.cardBrand.text = args.details.brand
        binding.cardCountry.text = args.details.country
        binding.cardType.text = args.details.type.uppercase()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}