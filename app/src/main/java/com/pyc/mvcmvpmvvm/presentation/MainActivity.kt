package com.pyc.mvcmvpmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.pyc.mvcmvpmvvm.databinding.ActivityMainBinding
import com.pyc.mvcmvpmvvm.presentation.adapter.TaskAdapter
import com.pyc.mvcmvpmvvm.presentation.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : TaskViewModel by viewModels()
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel
        setAdapter()
        setContentView(binding.root)
    }

    private fun setAdapter() {
        binding.recyclerViewTask.adapter = TaskAdapter()
    }
}