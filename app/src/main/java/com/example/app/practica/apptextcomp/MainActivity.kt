package com.example.app.practica.apptextcomp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.app.practica.apptextcomp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: TextComparisonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TextComparisonViewModel::class.java)

        binding.compareButton.setOnClickListener {
            viewModel.text1 = binding.editText1.text.toString()
            viewModel.text2 = binding.editText2.text.toString()
            viewModel.compareTexts() // Iniciar comparación


        }

        viewModel.comparisonResult.observe(this, Observer { result ->
            binding.resultTextView.text = result
        })
    }
}