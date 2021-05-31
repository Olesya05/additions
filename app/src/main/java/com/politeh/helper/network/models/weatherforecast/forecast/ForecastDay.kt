package com.politeh.helper.network.models.weatherforecast.forecast

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ForecastDay(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: Day,
    @SerializedName("astro") val astro: Astro,
    @SerializedName("hour") val hour: List<Hour>
): Parcelable