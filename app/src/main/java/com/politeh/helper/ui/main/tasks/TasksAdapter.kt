package com.politeh.helper.ui.main.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.politeh.helper.R
import com.politeh.helper.database.models.Task
import com.politeh.helper.ui.utils.DateTimeStringFormatter

class TasksAdapter(
    tasks: List<Task>,
    private val dateTimeStringFormatter: DateTimeStringFormatter
): RecyclerView.Adapter<TaskHolder>() {


    var tasks: List<Task> = tasks
    var onItemClickedListener: ((Task) -> Unit)? = null
    var onItemCheckChangeListener: ((Int, Boolean) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        return TaskHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }


    override fun getItemCount(): Int {
        return tasks.size
    }


    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        with(holder) {
            bindTask(tasks[position], dateTimeStringFormatter)

            setOnItemClickedListener(
                tasks[position],
                onItemClickedListener
            )

            setOnItemCheckChangeListener(
                position,
                onItemCheckChangeListener
            )
        }
    }


}


