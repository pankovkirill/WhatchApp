package com.example.watchapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.watchapp.databinding.ActivityMainBinding
import com.example.watchapp.model.*
import com.example.watchapp.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MainViewModel = getViewModel()

        with(binding) {
            viewModel.liveData.observe(this@MainActivity, { textTime.text = it })

            buttonStart.setOnClickListener {
                viewModel.start()
            }
            buttonPause.setOnClickListener {
                viewModel.pause()
            }
            buttonStop.setOnClickListener {
                viewModel.stop()
            }
        }
    }
}















