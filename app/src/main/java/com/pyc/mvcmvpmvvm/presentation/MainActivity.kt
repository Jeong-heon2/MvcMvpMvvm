package com.pyc.mvcmvpmvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.pyc.mvcmvpmvvm.data.datasource.task.Task
import com.pyc.mvcmvpmvvm.databinding.ActivityMainBinding
import com.pyc.mvcmvpmvvm.presentation.adapter.TaskAdapter
import com.pyc.mvcmvpmvvm.presentation.contract.TaskContract
import com.pyc.mvcmvpmvvm.presentation.task.TaskPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), TaskContract.View {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter = TaskAdapter()

    @Inject
    lateinit var viewAssistedFactory: TaskPresenter.ViewAssistedFactory

    private val taskPresenter : TaskPresenter by viewModels(
        factoryProducer = {TaskPresenter.provideFactory(viewAssistedFactory, this)}
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAdapter()
        setTaskAddButton()
    }

    private fun setAdapter() {
        binding.recyclerViewTask.adapter = adapter
    }

    private fun setTaskAddButton() {
        binding.buttonAddTask.setOnClickListener {
            taskPresenter.addTask()
        }
    }

    override fun setTaskList(tasks: List<Task>) {
        adapter.submitList(tasks)
    }
}