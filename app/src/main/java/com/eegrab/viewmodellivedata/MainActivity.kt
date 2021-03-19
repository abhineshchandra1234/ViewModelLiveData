package com.eegrab.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eegrab.viewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: TestViewModel

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            binding.tvCount.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            binding.tvBoolean.text = it.toString()
        })

        incrementText()
    }

    private fun incrementText(){
        binding.btnCount.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }
}