package com.example.bmi_calculator_safe_args_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bmi_calculator_safe_args_project.databinding.FragmentHomeBinding
import com.example.bmi_livedata_project.viewmodel.BmiViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: BmiViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)

        binding.btn.setOnClickListener {
            val weight = binding.weightEtx.text.toString().toDouble()
            val height = binding.heightEtx.text.toString().toDouble()
            viewModel.bmiCalculate(weight,height)
            val action = HomeFragmentDirections.resultAction()
            action.greet = "Welcome"
            findNavController().navigate(action)
        }
        return binding.root
    }
}