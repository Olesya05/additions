package com.politeh.helper.database.converters

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class Converters {

    @TypeConverter
    fun fromDateToString(date: LocalDate?): String? {
        return date?.toString()
    }

    @TypeConverter
    fun fromStringToDate(stringDate: String?): LocalDate? {
        return if(stringDate == null)
        {
            null
        } else {
            LocalDate.parse(stringDate)
        }
    }


    @TypeConverter
    fun fromTimeToString(time: LocalTime?): String? {
        return time?.toString()
    }

    @TypeConverter
    fun fromStringToTime(stringTime: String?): LocalTime? {
        return if(stringTime == null)
        {
            null
        } else {
            LocalTime.parse(stringTime)
        }
    }

}