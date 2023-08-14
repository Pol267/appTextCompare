package com.example.app.practica.apptextcomp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextComparisonViewModel : ViewModel() {

    private val _comparisonResult = MutableLiveData<String>()
    val comparisonResult: LiveData<String> = _comparisonResult

    var text1: String = ""
    var text2: String = ""

    fun compareTexts() {
        _comparisonResult.value = if (text1 == text2) {
            "Los textos son iguales"
        } else {
            "Los textos son distintos"
        }
    }
}
