package com.politeh.helper.ui.task.fragments.timepicker

import android.os.Bundle
import com.politeh.helper.ui.task.fragments.datepicker.DatePickerFragment
import java.time.LocalDate
import java.time.LocalTime

internal object ExtraKeys {

    const val ARG_TIME = "time"
}


internal data class Extras(
    val taskTime: LocalTime
)


internal fun extractExtras(args: Bundle) : Extras {
    return Extras(
        taskTime = args.getSerializable(ExtraKeys.ARG_TIME) as LocalTime
    )
}


fun TimePickerFragment.Companion.newInstance(time: LocalTime) : TimePickerFragment {
    return TimePickerFragment()
        .apply {
            arguments = Bundle().apply {
                putSerializable(ExtraKeys.ARG_TIME, time)
            }
        }
}