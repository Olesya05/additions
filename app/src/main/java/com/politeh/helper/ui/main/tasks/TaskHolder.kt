package com.politeh.helper.ui.main.tasks

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.politeh.helper.database.models.Task
import com.politeh.helper.ui.utils.DateTimeStringFormatter
import kotlinx.android.synthetic.main.item_task.view.*

class TaskHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


    private val taskCheckBox = itemView.taskCb
    private val taskName = itemView.taskNameTv
    private val taskDate = itemView.taskDateTv




    fun bindTask(task: Task, dateTimeStringFormatter: DateTimeStringFormatter) {
        taskCheckBox.setOnCheckedChangeListener(null)
        taskCheckBox.isChecked = task.isDone
        taskName.text = task.name
        taskDate.text = dateTimeStringFormatter.getDateTimeString(task.date, task.time)
    }


    fun setOnItemClickedListener(task: Task,
                                 listener: ((Task) -> Unit)?) {
        itemView.setOnClickListener {
            listener?.invoke(task)
        }
    }


    fun setOnItemCheckChangeListener(position: Int,
                                     listener: ((Int, Boolean) -> Unit)?) {
        taskCheckBox.setOnCheckedChangeListener { _, isChecked ->
            listener?.invoke(position, isChecked)
        }
    }


}