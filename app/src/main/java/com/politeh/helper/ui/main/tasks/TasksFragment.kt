package com.politeh.helper.ui.main.tasks

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.politeh.helper.HelperApplication
import com.politeh.helper.R
import com.politeh.helper.database.models.Task
import com.politeh.helper.ui.base.fragments.BaseFragment
import com.politeh.helper.ui.task.TaskActivity
import com.politeh.helper.ui.task.newInstance
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import kotlinx.android.synthetic.main.fragment_tasks.*
import java.util.*
import javax.inject.Inject

class TasksFragment(): BaseFragment(R.layout.fragment_tasks), TasksContract.View {


    @Inject lateinit var presenter: TasksPresenter
    @Inject lateinit var dateTimeStringFormatter: DateTimeStringFormatter

    private lateinit var tasksAdapter: TasksAdapter


    override fun injectDependencies() {
        (requireContext().applicationContext as HelperApplication).getAppComponent()
            .createTasksComponent()
            .create(this)
            .inject(this)
    }


    override fun init() {
        presenter.init()
        presenter.tasks.observe(viewLifecycleOwner, Observer {
            setTasks(it)
        })
        initView()
    }


    private fun setTasks(tasks: List<Task>) {
        tasksAdapter.tasks = tasks
        tasksAdapter.notifyDataSetChanged()
    }


    private fun initView() {
        initMenu()
        initRecycleView()
    }


    private fun initMenu() {
        setHasOptionsMenu(true)
    }


    private fun initRecycleView() = with(tasksRv) {
        layoutManager = initLayoutManager()
        adapter = initAdapter()
    }


    private fun initLayoutManager(): LinearLayoutManager {
        return LinearLayoutManager(requireContext())
    }


    private fun initAdapter(): TasksAdapter {
        return TasksAdapter(listOf(), dateTimeStringFormatter).apply {
            onItemClickedListener = {task ->
                presenter.onItemClickedListener(task)
            }

            onItemCheckChangeListener = {position, isChecked ->
                presenter.onItemCheckChanged(position, isChecked)
            }
        }.also {
            tasksAdapter = it
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        return inflater.inflate(R.menu.menu_tasks_fragment, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.addTasksMenuBtn -> {
                presenter.onAddTaskMenuBtnClicked()
                true
            }
            else -> false
        }
    }


    override fun launchTaskActivity(task: Task) {
        startActivity(
            TaskActivity.newInstance(
                requireContext(),
                task
            )
        )
    }
}