package com.politeh.helper.ui.task

import android.content.Context
import android.content.Intent
import com.politeh.helper.database.models.Task

internal object ExtraKeys {

    const val EXTRA_TASK_KEY = "task_key"
}


internal data class Extras(
    val task: Task
)


internal fun extractExtras(intent: Intent) : Extras {
    return Extras(
        task = intent.getSerializableExtra(ExtraKeys.EXTRA_TASK_KEY) as Task
    )
}


fun TaskActivity.Companion.newInstance(context: Context, task: Task): Intent {
    return Intent(context, TaskActivity::class.java).apply {
        putExtra(ExtraKeys.EXTRA_TASK_KEY, task)
    }
}