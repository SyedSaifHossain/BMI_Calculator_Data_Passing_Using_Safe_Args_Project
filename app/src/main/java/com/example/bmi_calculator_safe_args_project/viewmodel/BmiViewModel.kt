package com.example.bmi_livedata_project.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class BmiViewModel: ViewModel() {
    var bmi : MutableLiveData<Double> = MutableLiveData()
    var catagory : MutableLiveData<String> = MutableLiveData()

    fun bmiCalculate(weight: Double, height: Double) {

        bmi.value = weight / ((height / 100) * (height / 100))

        catagory.value = when (String.format("%.1f", bmi.value).toDouble()) {
            in 0.0..18.4 -> underweight
            in 18.5..24.9 -> normal
            in 25.0..29.9 -> overweight
            in 30.0..34.9 -> obesity1
            in 35.0..39.9 -> obesity2
            else -> obesity3
        }


    }
    companion object {
        var underweight = "UNDERWEIGHT"
        var normal = "NORMAL"
        var overweight = "OVERWEIGHT"
        var obesity1 = "OBESITY 1"
        var obesity2 = "OBESITY 2"
        var obesity3 = "OBESITY 3"

    }

}