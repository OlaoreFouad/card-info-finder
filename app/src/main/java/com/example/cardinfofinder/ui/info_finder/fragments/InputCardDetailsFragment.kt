package com.example.cardinfofinder.ui.info_finder.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.cardinfofinder.data.common.ResultStatus
import com.example.cardinfofinder.data.models.info_finder.DomainCardDetails
import com.example.cardinfofinder.databinding.FragmentInputCardDetailsBinding
import com.example.cardinfofinder.ui.info_finder.viewmodels.InputCardDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

class InputCardDetailsFragment : Fragment() {

    private var _binding: FragmentInputCardDetailsBinding? = null
    val binding: FragmentInputCardDetailsBinding
        get() = _binding!!

    private lateinit var navController: NavController
    private val viewModel: InputCardDetailsViewModel by activityViewModels()

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

        viewModel.information.observe(viewLifecycleOwner, {
            binding.isLoading = it?.status == ResultStatus.LOADING
            when (it?.status) {
                ResultStatus.SUCCESS -> {
                    val data = DomainCardDetails(
                        bank = it!!.data?.bank?.name!!,
                        brand = it.data!!.brand!!,
                        country = it.data.country?.name + it.data.country?.emoji,
                        type = it.data.type!!
                    )
                    viewModel.complete()
                    binding.cardNumberInput.setText("")
                    navController.navigate(
                        InputCardDetailsFragmentDirections.actionInputCardDetailsFragmentToCardDetailsFragment(data)
                    )
                }
                ResultStatus.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        })

        binding.checkCardDetailsButton.setOnClickListener {
            val cardNumber = binding.cardNumberInput.rawText.toString()
            if (cardNumber.length < 8) {
                Toast.makeText(requireContext(), "Please enter up to 8 characters", Toast.LENGTH_LONG).show()
            } else {
                viewModel.lookup(cardNumber)
            }
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}