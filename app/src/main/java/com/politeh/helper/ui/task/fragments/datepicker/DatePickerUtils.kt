package com.politeh.helper.ui.task.fragments.datepicker

import android.os.Bundle
import java.time.LocalDate

internal object ExtraKeys {

    const val ARG_DATE = "date"
}


internal data class Extras(
    val taskDate: LocalDate
)


internal fun extractExtras(args: Bundle) : Extras {
    return Extras(
        taskDate = args.getSerializable(ExtraKeys.ARG_DATE) as LocalDate
    )
}


fun DatePickerFragment.Companion.newInstance(date: LocalDate) : DatePickerFragment {
    return DatePickerFragment()
        .apply {
            arguments = Bundle().apply {
                putSerializable(ExtraKeys.ARG_DATE, date)
            }
        }
}