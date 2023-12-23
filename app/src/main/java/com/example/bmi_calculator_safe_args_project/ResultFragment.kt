package com.example.bmi_calculator_safe_args_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.bmi_calculator_safe_args_project.databinding.FragmentResultBinding
import com.example.bmi_livedata_project.viewmodel.BmiViewModel

class ResultFragment : Fragment() {
    private lateinit var binding : FragmentResultBinding
    private lateinit var viewModel: BmiViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //val greet = ResultFragmentArgs.fromBundle(arguments).greet
        val greet = ResultFragmentArgs.fromBundle(requireArguments()).greet
        binding = FragmentResultBinding.inflate(inflater,container,false)

        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)
        viewModel.bmi.observe(viewLifecycleOwner, { score ->

            binding.scoreTv.text = String.format("%.1f", score)

        })
        viewModel.catagory.observe(viewLifecycleOwner, { catagory ->
            binding.catagoryTv.text = catagory
        })
        return binding.root
    }

}