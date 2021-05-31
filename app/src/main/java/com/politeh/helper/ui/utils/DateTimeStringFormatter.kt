package com.politeh.helper.ui.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class DateTimeStringFormatter {


    private val fullDateFormatter = DateTimeFormatter.ofPattern("EEE, d MMM, yyyy", Locale.ENGLISH)
    private val shortDateFormatter = DateTimeFormatter.ofPattern("MMMM d", Locale.ENGLISH)
    private val dayDateFormatter = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH)
    private val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm", Locale.ENGLISH)




    fun getDateTimeString(date: LocalDate?, time: LocalTime?): String {
        var dateTimeString = ""

        if(date != null) {
            dateTimeString = date.format(fullDateFormatter)

            if(time != null) {
                dateTimeString += ", $time"
            }
        }

        return dateTimeString
    }


    fun getFullDateString(date: LocalDate?): String? {
        return date?.format(fullDateFormatter)
    }


    fun getDateFromString(dateString: String): LocalDate? {
        return if(dateString.isEmpty()) {
            null
        } else {
            LocalDate.parse(dateString, fullDateFormatter)
        }
    }


    fun getShortDateString(date: LocalDate): String {
        return date.format(shortDateFormatter)
    }


    fun getDayDateString(date: LocalDate): String {
        return date.format(dayDateFormatter)
    }


    fun getTimeFromForecastHour(dateString: String): String {
        val date = LocalDateTime.parse(dateString, dateTimeFormatter)
        val time = date.toLocalTime()
        return time.toString()
    }


}